package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class UnorderedArrayPQ<Item extends Comparable<Item>> {

    private Item[] pq;
    private int N;

    public UnorderedArrayPQ(int capacity) {
        pq = (Item[]) new Comparable[capacity];
    }

    public void insert(Item item) {
        pq[N++] = item;
    }

    public Item delMax() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (pq[i].compareTo(pq[max]) > 0) {
                max = i;
            }
        }
        swap(max, N - 1);
        return pq[--N];
    }

    public void swap(int i, int j){
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
    UnorderedArrayPQ queue = new UnorderedArrayPQ(9);
        queue.insert(3);
        queue.insert(54);
        queue.insert(5);
        queue.insert(76);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(32);
        queue.insert(13);
        System.out.println(queue.delMax());
    }
}
