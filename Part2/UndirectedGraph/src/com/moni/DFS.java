package com.moni;

import java.util.Stack;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class DFS {

    boolean marked[];

    public DFS(UndirectedGraph G, int v) {
        marked = new boolean[G.numberOfVertices()];
        dfs(G, v);
    }

    // With recursion
    public void dfs(UndirectedGraph G, int v ){
        marked[v] = true;
        for (int w: G.adj[v]){
            if(!marked[w]){
                dfs(G, w);
            }
        }
    }

    // With stack
    public void dfsWithStack(UndirectedGraph G, int v ) {
        Stack stack = new Stack();
        stack.push(v);
        marked[v] = true;
        while (!stack.isEmpty()){
            Integer current = (Integer)stack.peek();
            for (int i : G.adj[current]){
                if (!marked[i]){
                    marked[i] = true;
                    current = i;
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
        DFS search = new DFS(graph, 0);
        search.dfsWithStack(graph, 0);
        System.out.println(search);
    }
}
