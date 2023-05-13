package com.faang.me.apnacollege.graphs;

import java.util.*;

class HasPathDFS {

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createGraph(5);

        boolean hasPath = hasPath(graph, 0, 4, new boolean[5]);
        System.out.println(hasPath);
    }

    
    // TC - O(V + E) V - Vertex and E - Edges
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {

        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {

            Edge e = graph[src].get(i);
            // e.dest = graph neighbour
            if (!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                return true;
            }
        }

        return false;

    }

    private static ArrayList<Edge>[] createGraph(int vertexSize) {
        ArrayList<Edge>[] graph = new ArrayList[vertexSize];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - Vertex
        graph[0].add(new Edge(0, 1, 5));

        //1 - Vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 - Vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 - Vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 - Vertex
        graph[4].add(new Edge(4, 2, 2));

        return graph;
    }

    static class Edge {

        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
}
