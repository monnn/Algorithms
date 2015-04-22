package com.moni;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class Prim {

    private Edge[] edgeTo;
    private double[] distTo;
    boolean[] marked;
    PriorityQueue<Double> pq;
    Queue<Integer> q;
    boolean[] visited;

    public Prim(WeightedGraph G) {
        edgeTo = new Edge[G.V];
        distTo = new double[G.V];
        marked = new boolean[G.V];
        visited = new boolean[G.V];
        pq = new PriorityQueue<Double>();
        q = new LinkedList<Integer>();
        for (int v = 0; v < G.V; v++) {
            if (!marked[v]) {
                prim(G, v);
            }
        }
    }

    public void prim(WeightedGraph G, int s) {
        distTo[s] = 0.0;
        pq.add(distTo[s]);
        q.add(s);
        for (Edge e : G.adj[s]) {
            int w = e.other(s);
            distTo[w] = e.weight;
            q.add(w);
            pq.add(distTo[w]);
        }
        while (!q.isEmpty()) {
            int v = q.remove();
            marked[v] = true;
            for (Edge e : G.adj[v]) {
                int w = e.other(v);
                if (!marked[w]) {
                    distTo[w] = e.weight;
                    edgeTo[w] = e;
                    if(!q.contains(w)){
                        q.add(w);
                        pq.add(distTo[w]);
                    }
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new LinkedList<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.add(e);
            }
        }
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight;
        return weight;
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(7);
        Edge a = new Edge(1, 0, 3.14);
        Edge b = new Edge(0, 3, 2.14);
        Edge c = new Edge(4, 5, 2.04);
        Edge d = new Edge(6, 0, 1.14);
        Edge e = new Edge(1, 3, 1.10);
        Edge f = new Edge(6, 5, 1);
        Edge g = new Edge(6, 4, 4.3);
        graph.addEdge(g);
        graph.addEdge(f);
        graph.addEdge(a);
        graph.addEdge(b);
        graph.addEdge(c);
        graph.addEdge(d);
        graph.addEdge(e);
        Prim mst = new Prim(graph);
        for (Edge m : mst.edges()) {
            System.out.println(m);
        }
        System.out.println(mst.weight());
        System.out.println(mst.pq);
    }
}
