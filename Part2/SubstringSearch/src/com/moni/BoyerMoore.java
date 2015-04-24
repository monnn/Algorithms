package com.moni;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BoyerMoore {

    private final int R = 256;
    private int[] right;

    public String search(String text, String pattern) {
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < pattern.length(); j++) {
            right[pattern.charAt(j)] = j;
        }
        int M = pattern.length();
        int N = text.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M-1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i+j)) {
                    skip = Math.max(1, j - right[text.charAt(i+j)]);
                    break;
                }
            }
            if (skip == 0){
                return "Substring found! Starting at position " + i;
            }
        }
        return "Substring not found";
    }

    public static void main(String[] args){
        BoyerMoore bm = new BoyerMoore();
        String result = bm.search("asdfghjklqwertyuioop", "qwerty");
        System.out.println(result);
    }
}
