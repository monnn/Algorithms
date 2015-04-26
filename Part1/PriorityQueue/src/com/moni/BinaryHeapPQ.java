package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BinaryHeapPQ<Item extends Comparable<Item>> {

    private Item[] pq;
    private int N;

    public BinaryHeapPQ(int capacity) {
        pq = (Item[]) new Comparable[capacity + 1];
        N = 0;
    }

    public void insert(Item item){
        pq[++N] = item;
        swim(N);
    }

    public Item delMax(){
        Item max = pq[1];
        swap(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    public void swim(int k){
        while (k > 1 && pq[k].compareTo(pq[k/2]) > 0){
            swap(k, k/2);
            k = k/2;
        }
    }

    public void sink(int k){
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && pq[j].compareTo(pq[j + 1]) < 0) {
                j++;
            }
            if (pq[j].compareTo(pq[k]) <= 0){
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    public void swap(int i, int j){
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        BinaryHeapPQ queue = new BinaryHeapPQ(10);
        queue.insert(3);
        queue.insert(54);
        queue.insert(5);
        queue.insert(76);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(32);
        queue.insert(13);
        for (int i = 1; i < queue.pq.length ; i++) {
            System.out.println(queue.pq[i]);
        }
    }
}
