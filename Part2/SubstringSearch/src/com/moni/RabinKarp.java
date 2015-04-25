package com.moni;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class RabinKarp {

    private String pattern;
    private long patternHash;
    private int M;
    private long Q;
    private int R;
    private long RM;

    public RabinKarp(String pattern) {
        this.pattern = pattern;
        R = 256;
        M = pattern.length();
        Q = longRandomPrime();
        RM = 1;
        for (int i = 1; i <= M-1; i++)
            RM = (R * RM) % Q;
        patternHash = hash(pattern, M);
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (R * h + key.charAt(j)) % Q;
        return h;
    }

    //check ala Las Vegas
    private boolean check(String text, int i) {
        for (int j = 0; j < M; j++)
            if (pattern.charAt(j) != text.charAt(i + j))
                return false;
        return true;
    }

    public String search(String text) {
        int N = text.length();
        long textHash = hash(text, M);
        if ((patternHash == textHash) && check(text, 0)){
            return "Substring found! ";
        }
        for (int i = M; i < N; i++) {
            textHash = (textHash + Q - RM*text.charAt(i-M) % Q) % Q;
            textHash = (textHash*R + text.charAt(i)) % Q;
            int position = i - M + 1;
            if ((patternHash == textHash) && check(text, position)) {
                return "Substring found! Starting at position " + position;
            }
        }
        return "Substring not found";
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public static void main(String[] args) {
        String pattern = "qwerty";
        String text = "asdfghjklqwertyuioop";
        RabinKarp searcher = new RabinKarp(pattern);
        System.out.println(searcher.search(text));

    }
}
