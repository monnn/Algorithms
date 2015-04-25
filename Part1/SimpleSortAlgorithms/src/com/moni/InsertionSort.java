package com.moni;

import java.util.Random;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class InsertionSort {

    Random random = new Random();
    int[] array;


    public InsertionSort(){
        array = new int[20];
        for (int i = 0; i < array.length - 1; i++){
            array[i] = random.nextInt(20);
        }
    }

    public void insertionSort() {
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            while ((i > 0) && (array[i - 1] > temp)) {
                array[i] = array[i-1];
                i--;
            }
            array[i] = temp;
        }
    }

    public void displayTheArray(){
        StringBuffer displayedArray = new StringBuffer();
        for (int m = 0; m < array.length; m++){
            displayedArray.append(array[m]);
            displayedArray.append(" | ");
        }
        System.out.println(displayedArray);

    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        sort.displayTheArray();
        sort.insertionSort();
        sort.displayTheArray();
    }
}
