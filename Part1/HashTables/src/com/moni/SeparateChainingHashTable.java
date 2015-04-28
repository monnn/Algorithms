package com.moni;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class SeparateChainingHashTable<Key, Value> {

    private static final int INIT_CAPACITY = 4;
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    private class Node{
        Object key;
        Object value;
        Node next;
    }

    public SeparateChainingHashTable() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashTable(int m) {
        M = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private Value get(Key key){
        int i = hash(key);
        return st[i].get(key);
    }

    private void put(Key key, Value value){
        if (value == null){
            delete(key);
            return;
        }
        int i = hash(key);
        if (!st[i].contains(key)) {
            N++;
        }
        st[i].put(key, value);
    }

    private boolean contains(Key key){
        return get(key) != null;
    }

    private void delete(Key key){
        int i = hash(key);
        if (st[i].contains(key)){
            N--;
        }
        st[i].delete(key);
    }

    private void resize(int chains) {
        SeparateChainingHashTable<Key, Value> temp = new SeparateChainingHashTable<Key, Value>(chains);
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.M  = temp.M;
        this.N  = temp.N;
        this.st = temp.st;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys()) {
                queue.add(key);
            }
        }
        return queue;
    }
    public static void main(String[] args) {
        SeparateChainingHashTable<String, Integer> st = new SeparateChainingHashTable<String, Integer>();
        st.put("a", 9);
        st.put("h", 3);
        st.put("t", 5);
        st.put("y", 16);
        System.out.println(st.get("y"));
        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
    }
}
