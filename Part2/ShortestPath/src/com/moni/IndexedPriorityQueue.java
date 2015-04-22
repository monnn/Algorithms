package com.moni;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class IndexedPriorityQueue<Key extends Comparable<Key>> implements  Iterable<Integer> {

    private int maxSize;
    private int N;
    private int[] pq;
    private int[] qp;
    private Key[] keys;

    public IndexedPriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        keys = (Key[]) new Comparable[maxSize + 1];
        pq = new int[maxSize + 1];
        qp = new int[maxSize + 1];
        for (int i = 0; i <= maxSize; i++){
            qp[i] = -1;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(int i) {
        return qp[i] != -1;
    }

    public int size() {
        return N;
    }

    public void insert(int i, Key key) {
        if (contains(i)) {
            throw new IllegalArgumentException("index is already in the priority queue");
        }
        N++;
        qp[i] = N;
        pq[N] = i;
        keys[i] = key;
        swim(N);
    }

    public int minIndex() {
        return pq[1];
    }

    public Key minKey() {
        return keys[pq[1]];
    }

    public int delMin() {
        int min = pq[1];
        exch(1, N--);
        sink(1);
        qp[min] = -1;
        keys[pq[N+1]] = null;
        return min;
    }

    public Key keyOf(int i) {
        if (!contains(i)) {
            throw new NoSuchElementException("index is not in the priority queue");
        } else {
            return keys[i];
        }
    }

    public void changeKey(int i, Key key) {
        if (!contains(i)) {
            throw new NoSuchElementException("index is not in the priority queue");
        }
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

    public void delete(int i) {
        if (!contains(i)) {
            throw new NoSuchElementException("index is not in the priority queue");
        }
        int index = qp[i];
        exch(index, N--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i]; pq[i] = pq[j]; pq[j] = swap;
        qp[pq[i]] = i; qp[pq[j]] = j;
    }

    private void swim(int k)  {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public Iterator<Integer> iterator() { return new HeapIterator(); }

    private class HeapIterator implements Iterator<Integer> {
        private IndexedPriorityQueue<Key> copy;
        public HeapIterator() {
            copy = new IndexedPriorityQueue<Key>(pq.length - 1);
            for (int i = 1; i <= N; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }

    public static void main(String[] args) {
        String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };
        IndexedPriorityQueue<String> pq = new IndexedPriorityQueue<String>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }
        while (!pq.isEmpty()) {
            int i = pq.delMin();
            System.out.println(i + " " + strings[i]);
        }
    }
}
