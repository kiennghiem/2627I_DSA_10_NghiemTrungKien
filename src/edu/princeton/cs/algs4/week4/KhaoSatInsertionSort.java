package edu.princeton.cs.algs4.week4;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class KhaoSatInsertionSort {

    public static void main(String[] args) {

        System.out.println("Loai 1.1: du lieu cho san, do dai n = 1000");
        In in = new In("algs4-data\\1Kints.txt");
        int[] primitiveA1dot1 = in.readAllInts();
        for (int i = 0; i < 50; i++) { // WARM-UP PHASE: Let the JIT compiler optimize the code
            Integer[] dummy = Arrays.stream(primitiveA1dot1).boxed().toArray(Integer[]::new);
            Insertion.sort(dummy);
        }

        int iterations = 3;
        long totalTime = 0;
        for (int i = 1; i < iterations + 1; i++) {
            Integer[] tempA1dot1 = Arrays.stream(primitiveA1dot1).boxed().toArray(Integer[]::new);

            long start = System.currentTimeMillis();

            Insertion.sort(tempA1dot1);  // xử lý dữ liệu trong mảng a

            long end = System.currentTimeMillis();

            long time = end - start;  // thời gian chạy bằng end - start
            System.out.println("Thoi gian chay lan " + i + ": " + time);
            totalTime += time;
        }
        System.out.println("Trung binh thoi gian chay: " + totalTime/iterations);

        System.out.println("Loai 1.2: du lieu cho san, do dai n = 4000");
        in = new In("algs4-data\\4Kints.txt");
        int[] primitiveA1dot2 = in.readAllInts();
        for (int i = 0; i < 50; i++) { // WARM-UP PHASE
            Integer[] dummy = Arrays.stream(primitiveA1dot2).boxed().toArray(Integer[]::new);
            Insertion.sort(dummy);
        }
        iterations = 3;
        totalTime = 0;
        for (int i = 1; i < iterations + 1; i++) {
            Integer[] tempA1dot2 = Arrays.stream(primitiveA1dot2).boxed().toArray(Integer[]::new);
            long start = System.currentTimeMillis();
            Insertion.sort(tempA1dot2);
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("Thoi gian chay lan " + i + ": " + time);
            totalTime += time;
        }
        System.out.println("Trung binh thoi gian chay: " + totalTime/iterations);

        System.out.println("Loai 2.1: du lieu ngau nhien, do dai n = 1000");
        int size = 1000;
        Integer[] a2dot1 = new Integer[size];
        for (int i = 0; i < size; i++) {
            // Generates a random number between 0 (inclusive) and 999999 (exclusive)
            a2dot1[i] = ThreadLocalRandom.current().nextInt(0, 999999);
        }
        for (int i = 0; i < 50; i++) {  // WARM-UP PHASE
            Integer[] dummy = new Integer[size];
            for (int j = 0; j < size; j++) {
                dummy[j] = a2dot1[j];
            }
            Insertion.sort(dummy);
        }
        iterations = 5;
        totalTime = 0;
        for (int i = 1; i < iterations + 1; i++) {
            Integer[] tempA2dot1 = new Integer[size];
            for (int j = 0; j < size; j++) {
                tempA2dot1[j] = a2dot1[j];
            }
            long start = System.currentTimeMillis();
            Insertion.sort(tempA2dot1);
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("Thoi gian chay lan " + i + ": " + time);
            totalTime += time;
        }
        System.out.println("Trung binh thoi gian chay: " + totalTime/iterations);

        System.out.println("Loai 2.2: du lieu ngau nhien, do dai n = 4000");
        size = 4000;
        Integer[] a2dot2 = new Integer[size];
        for (int i = 0; i < size; i++) {
            // Generates a random number between 0 (inclusive) and 999999 (exclusive)
            a2dot2[i] = ThreadLocalRandom.current().nextInt(0, 999999);
        }
        for (int i = 0; i < 50; i++) {  // WARM-UP PHASE
            Integer[] dummy = new Integer[size];
            for (int j = 0; j < size; j++) {
                dummy[j] = a2dot2[j];
            }
            Insertion.sort(dummy);
        }
        iterations = 5;
        totalTime = 0;
        for (int i = 1; i < iterations + 1; i++) {
            Integer[] tempA2dot2 = new Integer[size];
            for (int j = 0; j < size; j++) {
                tempA2dot2[j] = a2dot2[j];
            }
            long start = System.currentTimeMillis();
            Insertion.sort(tempA2dot2);
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("Thoi gian chay lan " + i + ": " + time);
            totalTime += time;
        }
        System.out.println("Trung binh thoi gian chay: " + totalTime/iterations);

        System.out.println("Loai 3: du lieu sap xep xuoi, do dai n = 10000");
        size = 10000;
        for (int i = 0; i < 50; i++) { //WARM-UP PHASE
            Integer[] dummy = new Integer[size];
            for (int j = 0; j < size; j++) {
                dummy[j] = j;
            }
            Insertion.sort(dummy);
        }
        iterations = 3;
        totalTime = 0;
        for (int i = 1; i < iterations + 1; i++) {
            Integer[] tempA3 = new Integer[size];
            for (int j = 0; j < size; j++) {
                tempA3[j] = j;
            }
            long start = System.currentTimeMillis();
            Insertion.sort(tempA3);
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("Thoi gian chay lan " + i + ": " + time);
            totalTime += time;
        }
        System.out.println("Trung binh thoi gian chay: " + totalTime/iterations);

        System.out.println("Loai 4: du lieu sap xep nguoc, do dai n = 10000");
        size = 10000;
        for (int i = 0; i < 50; i++) { //WARM-UP PHASE
            Integer[] dummy = new Integer[size];
            for (int j = size - 1; j > -1; j--) {
                dummy[j] = j;
            }
            Insertion.sort(dummy);
        }
        iterations = 3;
        totalTime = 0;
        for (int i = 1; i < iterations + 1; i++) {
            Integer[] tempA4 = new Integer[size];
            for (int j = size - 1; j > -1; j--) {
                tempA4[j] = j;
            }
            long start = System.currentTimeMillis();
            Insertion.sort(tempA4);
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("Thoi gian chay lan " + i + ": " + time);
            totalTime += time;
        }
        System.out.println("Trung binh thoi gian chay: " + totalTime/iterations);

        System.out.println("Loai 5: du lieu toan cac gia tri bang nhau, do dai n = 10000");
        size = 10000;
        int arrValue = 7;
        for (int i = 0; i < 50; i++) { //WARM-UP PHASE
            Integer[] dummy = new Integer[size];
            for (int j = 0; j < size; j++) {
                dummy[j] = arrValue;
            }
            Insertion.sort(dummy);
        }
        iterations = 3;
        totalTime = 0;
        for (int i = 1; i < iterations + 1; i++) {
            Integer[] tempA5 = new Integer[size];
            for (int j = 0; j < size; j++) {
                tempA5[j] = arrValue;
            }
            long start = System.currentTimeMillis();
            Insertion.sort(tempA5);
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("Thoi gian chay lan " + i + ": " + time);
            totalTime += time;
        }
        System.out.println("Trung binh thoi gian chay: " + totalTime/iterations);
    }
}

