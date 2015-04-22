package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class WeightedDigraph {

    public int V;
    public int E;
    public Bag<DirectedEdge>[] adj;

    public WeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<DirectedEdge>();
        }
    }

    public void addEdge(DirectedEdge e){
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        E++;
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> list = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                if (e.to() > v) {
                    list.add(e);
                }
            }
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges ");
        for (int v = 0; v < V; v++) {
            s.append('\n');
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + " ");
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        WeightedDigraph graph = new WeightedDigraph(7);
        DirectedEdge a = new DirectedEdge(1, 2, 3.14);
        DirectedEdge b = new DirectedEdge(2, 3, 2.14);
        DirectedEdge c = new DirectedEdge(4, 5, 2.04);
        DirectedEdge d = new DirectedEdge(6, 2, 1.14);
        DirectedEdge e = new DirectedEdge(1, 3, 1.10);
        graph.addEdge(a);
        graph.addEdge(b);
        graph.addEdge(c);
        graph.addEdge(d);
        graph.addEdge(e);
        System.out.println(graph);
    }
}
