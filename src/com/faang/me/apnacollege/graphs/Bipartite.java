package com.faang.me.apnacollege.graphs;

import java.util.*;

class Bipartite {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.print(biPartite(graph));
    }

    public static boolean biPartite(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                if (!biPartiteUtil(graph, color, q)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean biPartiteUtil(ArrayList<Edge>[] graph, int[] color, Queue<Integer> q) {
        while (!q.isEmpty()) {

            int curr = q.remove();
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (color[e.dest] == -1) {
                    int neighCol = color[curr] == 0 ? 1 : 0; // add opposite color to vertex if it is '0'
                    color[e.dest] = neighCol;
                    q.add(e.dest);
                } else if (color[e.dest] == color[curr]) {
                    return false;
                }
            }
        }
        return true;

    }

    /*
		BIPARTITE
					0 -- 4
				  /	    /
				 1	   2
				  \	  /
				    3
	
	
     */
    private static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 VERTEX
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        // 1 
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        //2
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 4));

        //3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

        //4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(3, 2));

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
