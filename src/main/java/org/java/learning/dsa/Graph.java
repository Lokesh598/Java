package org.java.learning.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    static class Edge {
        int src;
        int dest;
    }

    int vertices;
    int edges;

    Edge[] edge;

    Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;

        edge = new Edge[edges];

        for (int i = 0; i < edges; i++) {
            edge[i] = new Edge();
        }
    }

    public static void main(String[] args) {
        int numOfVertices = 5;
        int noEdges = 8;

        Graph g = new Graph(numOfVertices, noEdges);

        g.edge[0].src = 1;
        g.edge[0].src = 2;

        g.edge[1].src = 1;   // edge 1---3
        g.edge[1].dest = 3;

        g.edge[2].src = 1;   // edge 1---4
        g.edge[2].dest = 4;

        g.edge[3].src = 2;   // edge 2---4
        g.edge[3].dest = 4;

        g.edge[4].src = 2;   // edge 2---5
        g.edge[4].dest = 5;

        g.edge[5].src = 3;   // edge 3---4
        g.edge[5].dest = 4;

        g.edge[6].src = 3;   // edge 3---5
        g.edge[6].dest = 5;

        g.edge[7].src = 4;   // edge 4---5
        g.edge[7].dest = 5;

        // print graph
//        for(int i = 0; i < noEdges; i++) {
//            System.out.println(g.edge[i].src + " - " + g.edge[i].dest);
//        }
        List<Integer>[] adj = new ArrayList[5];
        g.addEdge(adj, 0, 1);
        g.addEdge(adj, 1, 2);
        g.addEdge(adj, 1, 3);
        g.addEdge(adj, 0, 4);
        List<Integer> bfsList = g.bfs(5, adj);
        bfsList.stream().forEach(System.out::print);
        List<Integer> dfsList = g.dfs(5, adj);
        System.out.println();
        dfsList.stream().forEach(System.out::print);
        System.out.println();
        g.printGraph(adj, 5);
    }

    private void addEdge(List<Integer> adj[], int v, int u) {
        if (adj[v] == null) {
            adj[v] = new ArrayList<>();
        }
        if (adj[u] == null) {
            adj[u] = new ArrayList<>();
        }
        adj[v].add(u);
        adj[u].add(v);
    }

    private void printGraph(List<Integer> adj[], int V) {
        for (int i = 0; i < V; i++) {
            for (int x : adj[i]) {
                System.out.print(x + ",");
            }
            System.out.println();
        }
    }

    private List<Integer> bfs(int V, List<Integer>[] adj) {
        int[] vis = new int[V];

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        vis[0] = 1;

        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (int it : adj[node]) {
                if (vis[it] != 1) {
                    vis[it] = 1;
                    queue.add(it);
                }
            }
        }
        return res;
    }

    private List<Integer> dfs(int V, List<Integer>[] adj) {
        int[] vis = new int[V];
        int start = 0;//source
        List<Integer> ls = new ArrayList<>();
        dfsUtil(start, vis, adj, ls);
        return ls;
    }

    private List<Integer> dfsUtil(int node, int[] vis, List<Integer>[] adj, List<Integer> res) {
        vis[node] = 1;
        res.add(node);

        for (int it:adj[node]) {
            if (vis[it] != 1) {
                dfsUtil(it, vis, adj, res);
            }
        }
        return res;
    }


    static class DirectedGraph {
        static void addEdge(List<Integer> adj[], int u, int v)
        {
//            if (adj[v] == null) {
//                adj[v] = new ArrayList<>();
//            }
//            if (adj[u] == null) {
//                adj[u] = new ArrayList<>();
//            }
            adj[u].add(v);
        }

        static void topologicalSort(List<Integer> adj[], int V)
        {
            int[] in_degree = new int[V];

            for (int u = 0; u < V; u++) {
                for (int x:adj[u])
                    in_degree[x]++;
            }

            Queue<Integer> q=new LinkedList<>();
            for (int i = 0; i < V; i++)
                if (in_degree[i] == 0)
                    q.add(i);

            int count=0;
            while (q.isEmpty()==false) {
                int u = q.poll();


                for (int x: adj[u])
                    if (--in_degree[x] == 0)
                        q.add(x);

                count++;
            }
            if (count != V) {
                System.out.println("There exists a cycle in the graph");
            }
            else{
                System.out.println("There exists no cycle in the graph");
            }
        }

        public static void main(String[] args)
        {
            int V = 5;
            List<Integer> adj[] = new ArrayList[V];
            for (int i = 0; i < V; i++)
                adj[i] = new ArrayList<>();

            addEdge(adj,0, 1);
            addEdge(adj,4, 1);
            addEdge(adj,1, 2);
            addEdge(adj,2, 3);
            addEdge(adj,3, 1);

            topologicalSort(adj,V);
        }
    }

}
