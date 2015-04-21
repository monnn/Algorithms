package com.moni;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class ConnectedComponent {
    private boolean[] marked;
    private int[] id;
    private int count;
    private Queue<Integer> vertices;

    public ConnectedComponent(UndirectedGraph G) {
        vertices = new LinkedList<Integer>();
        marked = new boolean[G.numberOfVertices()];
        id = new int[G.numberOfVertices()];
        for (int v = 0; v < G.numberOfVertices(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(UndirectedGraph G, int v) {
        marked[v] = true;
        vertices.add(v);
        id[v] = count;
        for (int w : G.adj[v]) {
            if (!marked[w]){
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public static void main(String[] args) {
        int v = 9;
        UndirectedGraph graph = new UndirectedGraph(v);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(5, 6);
        graph.addEdge(4, 3);
        graph.addEdge(5, 1);
        graph.addEdge(0, 2);
        graph.addEdge(6, 2);
        graph.addEdge(1, 3);
        graph.addEdge(7, 8);
        ConnectedComponent cc = new ConnectedComponent(graph);
        System.out.println(cc.count + " components");

        Queue<Integer>[] components = new Queue[cc.count];
        for (int i = 0; i < cc.count; i++) {
            components[i] = new LinkedList<Integer>();
        }
        for (int m = 0; m < graph.numberOfVertices(); m++) {
            components[cc.id[m]].add(m);
        }
        for (int l = 0; l < cc.count; l++){
            for (int i : components[l]){
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }
}
