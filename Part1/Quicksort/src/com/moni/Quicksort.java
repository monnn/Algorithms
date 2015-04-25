package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class Quicksort {

    public int partition(Comparable[] a, int low, int high){
        int i = low;
        int j = high + 1;
        Comparable pivot = a[low];
        while(true) {
            while (a[++i].compareTo(pivot) < 0) {
                if (i == high) {
                    break;
                }
            }
            while (a[--j].compareTo(pivot) > 0) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j){
                break;
            }
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    public void sort(Comparable[] a){
        Shuffling.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a, 0, a.length);
    }

    public void sort(Comparable[] a, int low, int high){
        if (high <= low){
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
        assert isSorted(a, low, high);
    }

    public static void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (a[i].compareTo(a[i-1]) < 0) {
                return false;
            }
        return true;
    }

    public static void main(String[] args){
        Quicksort qs = new Quicksort();
        Integer[] array = {1,7,8,6,5,3,3,5,7,8,15,32,14,2,17,87,653,45};
        qs.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
