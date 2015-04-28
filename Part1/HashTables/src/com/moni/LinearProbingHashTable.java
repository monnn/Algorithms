package com.moni;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class LinearProbingHashTable<Key, Value> {

    private static final int INIT_CAPACITY = 4;
    private int N;
    private int M;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashTable() {
        this(INIT_CAPACITY);
    }

    public LinearProbingHashTable(int capacity) {
        M = capacity;
        keys = (Key[])new Object[M];
        values = (Value[])new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capacity) {
        LinearProbingHashTable<Key, Value> temp = new LinearProbingHashTable<Key, Value>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        M = temp.M;
    }

    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            return;
        }
        if (N >= M/2){
            resize(2*M);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (!contains(key)){
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRehash = keys[i];
            Value valToRehash = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N <= M/8){
            resize(M/2);
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null) queue.add(keys[i]);
        return queue;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        LinearProbingHashTable<String, Integer> st = new LinearProbingHashTable<String, Integer>();
        st.put("a", 9);
        st.put("h", 3);
        st.put("t", 5);
        st.put("y", 16);
        System.out.println(st.get("a"));
        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
    }
}

