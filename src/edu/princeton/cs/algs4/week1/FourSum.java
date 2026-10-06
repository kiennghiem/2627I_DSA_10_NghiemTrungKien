package edu.princeton.cs.algs4.week1;

// Bai 1.4.14
public class FourSum {

    public static int count(long[] a) {

        int N = a.length;
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    for (int t = k+1; t < N; t++) {
                        if (a[i] + a[j] + a[k] + a[t] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
