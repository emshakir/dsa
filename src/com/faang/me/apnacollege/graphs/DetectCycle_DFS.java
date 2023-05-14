package com.faang.me.apnacollege.graphs;

import java.util.*;


/*
   Detect Cycle in Un-directed array using DFS, here if Neighbour is visited and 
   it is not equal to parent i.e., current then cycle is present, and if neighbour
   is not visited and function return cycle present return true, in all other cases
   there is no cycle present.
*/
class DetectCycle_DFS {

    public static void main(String[] args) {

        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        boolean result = cycleDetection(graph);
        System.out.print(result);
    }

    public static boolean cycleDetectionUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent) {

        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (visited[e.dest] && e.dest != parent) {
                return true;
            } else if (!visited[e.dest] && cycleDetectionUtil(graph, visited, e.dest, curr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cycleDetection(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (cycleDetectionUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - Vertex
        //graph[0].add(new Edge(0, 1, 1));
        //1 - Vertex
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 - Vertex
        graph[2].add(new Edge(2, 1, 1));
        //graph[2].add(new Edge(2, 3, 1));
        // graph[2].add(new Edge(2, 4, 2));

        // 3 - Vertex
        graph[3].add(new Edge(3, 1, 3));
        //graph[3].add(new Edge(3, 2, 1));
        //graph[3].add(new Edge(3, 5, 1));

        // 4 - Vertex
        // graph[4].add(new Edge(4, 2, 2));
        //graph[4].add(new Edge(4, 6, 2));
        // 5 - Vertex
        //graph[5].add(new Edge(5, 3, 2));
        //graph[5].add(new Edge(5, 6, 2));
        // 6 - Vertex
        //graph[6].add(new Edge(6, 4, 2));
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
