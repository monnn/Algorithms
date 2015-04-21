package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class WeightedGraph {

    public int V;
    public int E;
    public Bag<Edge>[] adj;


    public WeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Edge>();
        }
    }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges ");
        for (int v = 0; v < V; v++) {
            s.append('\n');
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + " ");
            }
        }
        return s.toString();
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
        System.out.println(graph);
    }
}
