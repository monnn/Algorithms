package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BruteForce {

    public static String search (String text, String pattern){
        int N = text.length();
        int M = pattern.length();
        for (int i = 0; i <= N - M ; i++) {
            int j;
            for (j = 0; j < M ; j++) {
                if (pattern.charAt(j) != text.charAt(i + j)){
                    break;
                }
            }
            if (j == M){
                return "Substring found! Starting at position " + i;
            }
        }
        return "Substring not found";
    }

    public static void main(String[] args){
        System.out.println(search("asdfghjklqwertyuioop", "qwerty"));
    }
}
