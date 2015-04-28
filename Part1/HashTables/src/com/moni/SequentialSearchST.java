package com.moni;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class SequentialSearchST<Key, Value> {

    private int N;
    private Node first;

    private class Node{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key){
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)){
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value){
        if (value == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        N++;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public void delete(Key key){
        first = delete(key, first);
    }

    private Node delete(Key key, Node node){
        if (node == null){
            return null;
        }
        if (key.equals(node.key)){
            N--;
            return node.next;
        }
        node.next = delete(key, node.next);
        return node;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new LinkedList();
        for (Node node = first; node != null; node = node.next){
            queue.add(node.key);
        }
        return queue;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        st.put("a", 9);
        st.put("h", 3);
        st.put("t", 5);
        st.put("y", 16);
        System.out.println(st.get("t"));
        for (String s : st.keys()){
            System.out.println(s + " " + st.get(s));
        }
    }
}
