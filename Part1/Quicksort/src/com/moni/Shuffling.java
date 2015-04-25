package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class Shuffling {

    public static void shuffle(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            int r = (int) (i + (Math.random() * (a.length - i)));
            Comparable temp = a[r];
            a[r] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String[] args){
        Integer[] array = {1,7,8,6,5,3,3,5,7,8,15,32,14,2,17,87,653,45};
        shuffle(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
