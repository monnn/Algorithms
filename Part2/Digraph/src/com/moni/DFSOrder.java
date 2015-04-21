package com.moni;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class DFSOrder {

    private boolean[] marked;
    private Queue<Integer> preorder;
    private Queue<Integer> postorder;

    public DFSOrder(Digraph G) {
        postorder = new LinkedList<Integer>();
        preorder = new LinkedList<Integer>();
        marked = new boolean[G.numberOfVertices()];
        for (int v = 0; v < G.numberOfVertices(); v++)
            if (!marked[v]) {
                dfs(G, v);
            }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        preorder.add(v);
        for (int w : G.adj[v]) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.add(v);
    }

    public Iterable<Integer> post() {
        return postorder;
    }

    public Iterable<Integer> pre() {
        return preorder;
    }


    public Iterable<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<Integer>();
        for (int v : postorder) {
            reverse.push(v);
        }
        return reverse;
    }

    public static void main(String[] args) {
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
        DFSOrder order = new DFSOrder(graph);
        System.out.println("Preorder: ");
        for(int i: order.pre()){
            System.out.println(i + " ");
        }
        System.out.println("Postorder: ");
        for(int i: order.post()){
            System.out.println(i + " ");
        }
        System.out.println("Reverse postorder: ");
        for(int i: order.reversePost()){
            System.out.println(i + " ");
        }

    }
}

