package com.moni;

import java.util.Random;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class SelectionSort {

    Random random = new Random();
    int[] array;


    public SelectionSort() {
        array = new int[20];
        for (int l = 0; l < array.length - 1; l++) {
            array[l] = random.nextInt(20);
        }
    }

    public void selectionSort() {
        for (int i=0; i < array.length; i++){
            int minimum = i;
            for (int j = i; j < array.length; j++){
                if(array[j] < array[minimum]){
                    minimum = j;

                }
            }
            int temp = array[minimum];
            array[minimum] = array[i];
            array[i] = temp;
        }
    }

    public void displayTheArray() {
        StringBuffer displayedArray = new StringBuffer();
        for (int m = 0; m < array.length; m++) {
            displayedArray.append(array[m]);
            displayedArray.append(" | ");
        }
        System.out.println(displayedArray);

    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        sort.displayTheArray();
        sort.selectionSort();
        sort.displayTheArray();
    }
}
