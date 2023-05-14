package com.faang.me.apnacollege.graphs;

import java.util.*;

/*
   Detect Cycle in Directed graphs using DFS, we will make use of boolean array
   known as stack, which keep track of neighbours which are visited, 
   if neighbour is found in stack array, it means cycle is detected 
*/
class DetectCycleDirected_DFS {

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.print(isCycle(graph));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {

        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {
                if (isCycleUtil(graph, visited, stack, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, boolean[] stack, int curr) {

        visited[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            // Neighbour is in stack, cycle exist
            if (stack[e.dest]) {
                return true;
            }

            // find cycle for other Neighbours if returned true, cycle present
            if (!visited[e.dest] && isCycleUtil(graph, visited, stack, e.dest)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;

    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // No Cycle Present
        /*
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
		graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
         */
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 0));
        graph[3].add(new Edge(3, 2));

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
