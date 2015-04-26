package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class Heapsort<Item extends Comparable<Item>> {


    public void sort(Comparable[] pq){
        int N = pq.length;
        for (int k = N/2; k >= 1; k--) {
            sink(pq, k, N);
        }
        while (N > 1){
            swap(pq, 1, N--);
            sink(pq, 1, N);
        }
    }

    public void sink(Comparable[] pq, int k, int N){
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && pq[j-1].compareTo(pq[j]) < 0) {
                j++;
            }
            if (pq[j-1].compareTo(pq[k-1]) <= 0){
                break;
            }
            swap(pq, k, j);
            k = j;
        }
    }

    public void swap(Comparable[] pq, int i, int j){
        Comparable temp = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = temp;
    }

    public static void main(String[] args) {
        Heapsort hs = new Heapsort();
        Integer[] array = {1,3,5,73,2,1,9,76,5,32,2};
        hs.sort(array);
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
