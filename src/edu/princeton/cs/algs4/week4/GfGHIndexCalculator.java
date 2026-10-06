package edu.princeton.cs.algs4.week4;

import java.util.Arrays;

public class GfGHIndexCalculator {
    static int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];

        // Count the frequency of citations
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n)
                freq[n] += 1;
            else
                freq[citations[i]] += 1;
        }

        int idx = n;

        // variable to keep track of the count of papers
        // having at least idx citations
        int s = freq[n];
        while (s < idx) {
            idx--;
            s += freq[idx];
        }

        // return the largest index for which the count of
        // papers with at least idx citations becomes >= idx
        return idx;
    }

    public static void main(String[] args) {
        int[] citations = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 7, 8, 8, 9, 10, 10, 11, 12, 12, 13, 14, 15, 15, 16, 17, 18, 18, 19, 20, 20, 21, 22, 22, 23, 24, 25, 25, 26, 27, 28, 28, 29, 30, 30, 31, 32, 33, 34, 35, 35, 36, 37, 38, 39, 40, 40, 41, 42, 42, 43, 44, 45, 45, 46, 47, 48, 49, 50, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 98};
        System.out.println(hIndex(citations));
    }
}