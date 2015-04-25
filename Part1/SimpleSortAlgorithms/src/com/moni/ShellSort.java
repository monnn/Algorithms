package com.moni;

import java.util.Random;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class ShellSort {

    Random random = new Random();
    int[] array;


    public ShellSort(int arraySize) {
        array = new int[arraySize];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = random.nextInt(20);
        }
    }

    public void shellSort() {
        int temp, i, interval;
        for (interval = array.length / 2; interval > 0; interval /= 2) {
            for (i = interval; i < array.length; i++) {
                temp = array[i];
                while (i >= interval && temp < array[i - interval]) {
                    array[i] = array[i - interval];
                    i -= interval;
                }
                array[i] = temp;
            }
        }
//        int temp, i, j, interval;
//        for (interval = array.length / 2; interval > 0; interval /= 2) {
//            System.out.println(interval);
//            for (i = interval; i < array.length; i++) {
//                temp = array[i];
//                j = i;
//                while (j >= interval && temp < array[j - interval]) {
//                    array[j] = array[j - interval];
//                    j -= interval;
//                }
//                array[j] = temp;
//            }
//        }
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
        ShellSort sort = new ShellSort(10);
        sort.displayTheArray();
        sort.shellSort();
        sort.displayTheArray();
    }
}
