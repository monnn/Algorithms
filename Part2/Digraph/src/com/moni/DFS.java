package com.moni;

import java.util.Stack;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class DFS {

    boolean marked[];
    int[] edgeTo;
    int v;

    public DFS(Digraph G, int v) {
        this.v = v;
        marked = new boolean[G.numberOfVertices()];
        edgeTo = new int[G.numberOfVertices()];
        dfs(G, v);
    }

    public void dfs(Digraph G, int v ){
        marked[v] = true;
        for (int w: G.adj[v]){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public Iterable<Integer> pathTo(int v) {
        if (!marked[v]){
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != v; x = edgeTo[x])
            path.push(x);
        path.push(v);
        return path;
    }

    public static void main(String[] args){
        Digraph graph = new Digraph(7);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(5, 6);
        graph.addEdge(4, 3);
        graph.addEdge(5, 1);
        graph.addEdge(0, 2);
        graph.addEdge(6, 2);
        graph.addEdge(1, 3);
        int source = 5;
        DFS search = new DFS(graph, source);
        for (int w = 0; w < graph.numberOfVertices(); w++) {
            if (search.marked[w]) {
                System.out.println("There is a path between " + source + " and " + w);
            }
            }
        System.out.println("In connected component are: ");
        for (int i = 0; i < graph.numberOfVertices(); i++) {
            if (search.marked[i])
                System.out.println(i + " ");
        }
    }
}
