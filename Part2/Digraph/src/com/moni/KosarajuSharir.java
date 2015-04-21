package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class KosarajuSharir {

    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSharir(Digraph G) {
        DFSOrder order = new DFSOrder(G);
        marked = new boolean[G.numberOfVertices()];
        id = new int[G.numberOfVertices()];
        for (int v : order.reversePost()) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj[v]) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public static void main(String[] args) {
        int v = 9;
        Digraph graph = new Digraph(v);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(5, 6);
        graph.addEdge(4, 3);
        graph.addEdge(5, 1);
        graph.addEdge(0, 2);
        graph.addEdge(6, 2);
        graph.addEdge(1, 3);
        graph.addEdge(7, 8);
        KosarajuSharir scc = new KosarajuSharir(graph);
        System.out.println(scc.count + " components");

    }
}
