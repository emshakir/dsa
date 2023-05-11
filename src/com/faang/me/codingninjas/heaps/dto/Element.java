package com.faang.me.codingninjas.heaps.dto;

/**
 *
 * @author SHAKIR
 */
public class Element<T> {

    public T value;
    public int priority;

    public Element(T v, int p) {
        this.value = v;
        this.priority = p;
    }
}
