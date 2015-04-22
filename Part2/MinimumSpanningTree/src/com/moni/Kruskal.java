package com.moni;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class Kruskal {

    private double weight;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;

    public Kruskal(WeightedGraph G) {
        mst = new LinkedList<Edge>();
        pq = new PriorityQueue<Edge>();
        kruskal(G);
    }

    public void kruskal(WeightedGraph G){
        for (Edge e : G.edges()) {
            pq.add(e);
        }
        UF uf = new UF(G.V);
        while (!pq.isEmpty() && mst.size() < (G.V - 1)) {
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(e);
                weight += e.weight();
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(7);
        Edge a = new Edge(1, 2, 3.14);
        Edge b = new Edge(2, 3, 2.14);
        Edge c = new Edge(4, 5, 2.04);
        Edge d = new Edge(6, 2, 1.14);
        Edge e = new Edge(1, 3, 1.10);
        graph.addEdge(a);
        graph.addEdge(b);
        graph.addEdge(c);
        graph.addEdge(d);
        graph.addEdge(e);
        Kruskal mst = new Kruskal(graph);
        for (Edge m : mst.edges()) {
            System.out.println(m);
        }
        System.out.println(mst.weight);
    }

}
