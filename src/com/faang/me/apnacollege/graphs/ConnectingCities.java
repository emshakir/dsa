package com.faang.me.apnacollege.graphs;

import java.util.*;

class ConnectingCities {

    public static void main(String[] args) {

        int[][] cities = {
            {0, 1, 2, 3, 4},
            {1, 0, 5, 0, 7},
            {2, 5, 0, 6, 0},
            {3, 0, 6, 0, 0},
            {4, 7, 0, 0, 0}
        };
        int minimumCost = getMinimumCost(cities);
        System.out.print("Minimum Cost ::: " + minimumCost);
    }

    public static int getMinimumCost(int[][] cities) {
        boolean[] visited = new boolean[cities.length];
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        int finalCost = 0;
        
        while (!pq.isEmpty()) {
            Edge currEdge = pq.remove();
            if (!visited[currEdge.dest]) {
                visited[currEdge.dest] = true;
                finalCost += currEdge.cost;
                for (int i = 0; i < cities[currEdge.dest].length; i++) {
                    if (cities[currEdge.dest][i] != 0) {
                        pq.add(new Edge(i, cities[currEdge.dest][i]));
                    }
                }
            }
        }
        
        return finalCost;
    }

    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;
        
        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }
        
        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
}
