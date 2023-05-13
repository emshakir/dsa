package com.faang.me.apnacollege.graphs;

import java.util.*;

class BreadthFirstTraversal {

    public static void main(String[] args) {

        ArrayList<Edge>[] graph = createGraph(5);

        for (int i = 0; i < graph[2].size(); i++) {
            Edge edge = graph[2].get(i);
            System.out.print("src: " + edge.src + ", Dest: " + edge.dest + ", Wt: " + edge.wt + "\n");
        }

        bfs(graph);
    }

	// TC - O( V + E) V - Vertex and E - Edges

    public static void bfs(ArrayList<Edge>[] graph) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        q.add(0);

        while (!q.isEmpty()) {

            int curr = q.remove();
            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }

        }
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
