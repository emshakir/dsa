package com.faang.me.apnacollege.graphs;

import java.util.*;

class TopologicalSortUsing_BFS {

    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topologicalSortBfs(graph);
    }

    public static void topologicalSortBfs(ArrayList<Edge>[] graph) {

        int[] inDegree = new int[graph.length];
        calculateInDegree(graph, inDegree);
        Queue<Integer> q = new LinkedList<>();

        // Add Vertex in queue if inDegree is '0'
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if (inDegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

    }

    private static void calculateInDegree(ArrayList<Edge>[] graph, int[] inDegree) {

        for (int i = 0; i < graph.length; i++) {
            // i will be each vertex and j will be edges
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDegree[e.dest]++;
            }
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    static class Edge {

        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
}
