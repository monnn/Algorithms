package com.moni;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BFS {

    boolean marked[];

    public BFS(UndirectedGraph G, int v) {
        marked = new boolean[G.numberOfVertices()];
        bfs(G, v);
    }

    public void bfs(UndirectedGraph G, int v){
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
        UndirectedGraph graph = new UndirectedGraph(7);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(5, 6);
        graph.addEdge(4, 3);
        graph.addEdge(5, 1);
        graph.addEdge(0, 2);
        graph.addEdge(6, 2);
        graph.addEdge(1, 3);
        BFS search = new BFS(graph, 0);
        System.out.println(search);
    }

}
