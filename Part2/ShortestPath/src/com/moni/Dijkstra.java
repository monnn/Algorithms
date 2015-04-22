package com.moni;

import java.util.Stack;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class Dijkstra {

    double[] distTo;
    DirectedEdge[] edgeTo;
    IndexedPriorityQueue<Double> pq;

    public Dijkstra(WeightedDigraph G, int s) {
        distTo = new double[G.V];
        edgeTo = new DirectedEdge[G.V];
        for (int v = 0; v < G.V; v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq = new IndexedPriorityQueue<Double>(G.V);
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e : G.adj[v])
                visit(e);
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    private void visit(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        if (distTo[w] > (distTo[v] + e.weight())) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)){
                pq.changeKey(w, distTo[w]);
            } else {
                pq.insert(w, distTo[w]);
            }
        }
    }
    public static void main(String[] args) {
        WeightedDigraph graph = new WeightedDigraph(7);
        DirectedEdge a = new DirectedEdge(1, 2, 3.14);
        DirectedEdge b = new DirectedEdge(2, 3, 2.14);
        DirectedEdge c = new DirectedEdge(4, 5, 2.04);
        DirectedEdge d = new DirectedEdge(2, 6, 1.14);
        DirectedEdge f = new DirectedEdge(3, 6, 1.10);
        graph.addEdge(a);
        graph.addEdge(b);
        graph.addEdge(c);
        graph.addEdge(d);
        graph.addEdge(f);
        int s = 1;
        Dijkstra sp = new Dijkstra(graph, s);
        for (int t = 0; t < graph.V; t++) {
            if (sp.hasPathTo(t)) {
                System.out.printf(s + " to " + t + " (" + sp.distTo(t) + ") ");
                    for (DirectedEdge e : sp.pathTo(t)) {
                        System.out.print("   " + e);
                    }
                System.out.println();
            }
            else {
                System.out.println(s + " to " + t + " no path");
            }
        }
    }
}

