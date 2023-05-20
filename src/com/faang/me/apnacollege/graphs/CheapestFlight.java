package com.faang.me.apnacollege.graphs;

import java.util.*;

class CheapestFlight {

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 10}, {0, 4, 100}, {1, 2, 20}, {4, 3, 200}, {2, 3, 10}};
//      int flights[][] = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};

        int src = 0;
        int dest = 3;
        int k = 1;
        int cheapestFlight = getCheapestFlight(flights, src, dest, k);
        System.out.println("cheapest Flight ::" + cheapestFlight);
    }

    public static int getCheapestFlight(int[][] flights, int src, int dest, int k) {
        ArrayList<Edge>[] graph = new ArrayList[flights.length];
        createGraph(flights, graph);
        int[] dist = new int[graph.length];
        // Initializa all the distance with MAX_VALUE
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, 0));

        while (!q.isEmpty()) {

            Info currInfo = q.remove();

            if (currInfo.stops > k) {
                break;
            }

            for (int i = 0; i < graph[currInfo.vertex].size(); i++) {
                Edge e = graph[currInfo.vertex].get(i);
                int u = e.src;
                int v = e.dest;
                int w = e.wt;

                if (currInfo.cost + w < dist[v] && currInfo.stops <= k) {
                    dist[v] = currInfo.cost + w;
                    q.add(new Info(v, dist[v], currInfo.stops + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }

    }

    public static void createGraph(int[][] flights, ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int price = flights[i][2];

            graph[src].add(new Edge(src, dest, price));
        }
    }

    static class Edge {

        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int p) {
            this.src = s;
            this.dest = d;
            this.wt = p;
        }
    }

    static class Info {

        int vertex;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.vertex = v;
            this.cost = c;
            this.stops = s;
        }
    }
}
