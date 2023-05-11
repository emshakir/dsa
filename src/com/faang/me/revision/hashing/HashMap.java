package com.faang.me.revision.hashing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHAKIR
 */
public class HashMap<K, V> {

    private List<Node> buckets;
    private int bucket_size;
    private int size;
    private static final double THRESHOLD_LEVEL = 0.7;

    public HashMap() {
        this.buckets = new ArrayList<>(10);
        this.bucket_size = 10;
        this.size = 0;
    }

    private int getBucketIndex(K k) {
        int hash_code = k.hashCode();
        return Math.abs(hash_code) % bucket_size;
    }

    private void rehashing() {
        List<Node> temp = buckets;
        bucket_size = 2 * buckets.size();
        size = 0;
        buckets = new ArrayList<>(bucket_size);
        for (Node node : temp) {
            while (node != null) {
                put(node.k, node.v);
                size++;
                node = node.next;
            }
        }
    }

    public void put(K k, V v) {
        int bi = getBucketIndex(k);
        Node head = buckets.get(bi);
        while (head != null) {
            if (head.k.equals(k)) {
                head.v = v;
                return;
            }
            head = head.next;
        }
        Node newNode = new Node(k, v);
        size++;
        head = buckets.get(bi);
        newNode.next = head;
        buckets.set(bi, newNode);

        double lambda = size / bucket_size;
        if (lambda > THRESHOLD_LEVEL) {
            rehashing();
        }
    }

    public V delete(K k) {
        int bi = getBucketIndex(k);
        Node head = buckets.get(bi);
        if (head == null) {
            return null;
        }
        Node prev = null;
        while (head != null) {
            if (head.k.equals(k)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (prev != null) {
            prev.next = head.next;
        } else {
            buckets.set(bi, head.next);
        }
        size--;
        return head.v;
    }

    private class Node {

        K k;
        V v;
        Node next;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
}
