package edu.princeton.cs.algs4.week4;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InsertionSort1 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertIntoSorted(n, arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }

        bufferedReader.close();

    }
}

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    // Ham nay la de insert gia tri cuoi cung cua array vao danh sach DA SAP XEP dang truoc no
    public static void insertIntoSorted(int n, List<Integer> arr) {

        int temp = arr.get(n - 1);
        int i = n - 1;
        // index di tu n - 1 den 1, va gia tri phia duoi temp phai lon hon temp thi vong lap moi chay
        while (i > 0 && arr.get(i - 1) > temp) {
            arr.set(i, arr.get(i - 1));
            i--;
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        arr.set(i, temp);
    }

}

