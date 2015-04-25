package com.moni;

import java.util.Random;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BubbleSort {

    Random random = new Random();
    int[] array;


    public BubbleSort(){
        array = new int[20];
        for (int i = 0; i < array.length - 1; i++){
            array[i] = random.nextInt(20);
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    int temp;
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
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
        BubbleSort sort = new BubbleSort();
        sort.displayTheArray();
        sort.bubbleSort();
        sort.displayTheArray();
    }
}
