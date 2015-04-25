package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class MergeSort {

    public void merge(Comparable[]a, Comparable[]aux, int low, int mid, int high){
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        assert isSorted(a, low, mid);
        assert isSorted(a, mid + 1, high);
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid){
                a[k] = aux[j++];
            } else if (j > high){
                a[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0){
                a[k] = aux[j++];
            }else {
                a[k] = aux[i++];
            }
        }
        assert isSorted(a, low, high);
    }

    public void sort(Comparable[]a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
        assert isSorted(a, 0, a.length - 1);
    }

    public void sort(Comparable[]a,Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low)/2;
        sort(a, aux, low, mid);
        sort(a, aux, mid+1, high);
        merge(a, aux, low, mid, high);
    }
    
        private static boolean isSorted(Comparable[] a, int lo, int hi) {
            for (int i = lo + 1; i <= hi; i++)
                if (a[i].compareTo(a[i-1]) < 0) {
                    return false;
                }
            return true;
        }

    public static void main(String[] args){
        MergeSort m = new MergeSort();
        Integer[] array = {1,7,8,6,5,3,3,5,7,8,15,32,14,2,17,87,653,45};
        m.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
