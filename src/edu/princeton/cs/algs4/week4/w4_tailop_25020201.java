package edu.princeton.cs.algs4.week4;

import java.util.Arrays;
import java.util.Scanner;

public class w4_tailop_25020201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] citations = new int[n];

            // Doc so luot trich dan tung bai
            for (int i = 0; i < n; i++) {
                citations[i] = scanner.nextInt();
            }

            System.out.println(calculateHIndex(citations));
        }
        scanner.close();
    }

    public static int calculateHIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;

            if (citations[i] >= h) {
                return h;
            }
        }
        return 0; // Return 0 neu ko có trich dan
    }
}