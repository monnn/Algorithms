package com.moni;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BFS {

    boolean marked[];

    public BFS(Digraph G, int v) {
        marked = new boolean[G.numberOfVertices()];
        bfs(G, v);
    }

    public void bfs(Digraph G, int v){
        Queue<Integer> queue = new LinkedList<Integer>();
        marked[v] = true;
        queue.add(v);
        while (!queue.isEmpty()){
            Integer current = queue.remove();
            for(int i: G.adj[current]){
                if (!marked[i]){
                    queue.add(i);
                    marked[i] = true;
                }
            }
        }

    }

    public static void main(String[] args){
        int v = 7;
        Digraph graph = new Digraph(v);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(5, 6);
        graph.addEdge(4, 3);
        graph.addEdge(5, 1);
        graph.addEdge(0, 2);
        graph.addEdge(6, 2);
        graph.addEdge(1, 3);
        int source = 5;
        BFS search = new BFS(graph, source);
        for (int w = 0; w < graph.numberOfVertices(); w++) {
            if (search.marked[w]) {
                System.out.println("There is a path between " + source + " and " + w);
            }
        }
    }

}
