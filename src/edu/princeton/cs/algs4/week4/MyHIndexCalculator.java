package edu.princeton.cs.algs4.week4;

import java.util.Scanner;

public class MyHIndexCalculator {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = s.nextInt();
        }

        Selection.sort(arr, arr.length);

        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + ", ");
        }

        int hIndex = findHIndex(arr, arr.length);
        System.out.println("hIndex = " + hIndex);
    }

    /* Y tuong nay chua hay, vi vong while phia trong di tu gia tri cao nhat den thap nhat. Nen trong truong
    hop VD: 10 so: 1 1 1 1 1 1 9 9 9, thi while trong se lap 3 lan lien tuc voi n=9->4 (while ngoai lap 6 lan)
    chi de thay rang 9>=n va cho count=3, vong lap thu 7 (n=3) moi thay count=n va dung vong lap.
    Ta thu nghi den viec de vong while phia trong di tu gia tri thap nhat den cao nhat. Tuy nhien, neu array
    sau khi sap xep co hinh dang tang dan rat deu, va gia tri hIndex nam o giua array, thi viec lap tu dau
    hay tu cuoi array deu yeu cau while phia trong chay n->n/2 lan, vong while phia ngoai chay n/2 lan.
    => Do phuc tap O(n^2) (chua tinh thuat toan sort)
    => Cach nay tuy dung, nhung co do phuc tap rat lon.

     */
    public static int findHIndex(int[] a, int n) {

        n++;
        int count;
        int i;
        do {
            count = 0;
            // n giam de vong while phia duoi thuc hien dung
            n--;
            i = a.length - 1;

            while (i >= 0 && a[i] >= n) {
                count++;
                //System.out.println(i);
                i--;
            }
            //System.out.println("count = " + count + ", n = " + n);
        }
        while (count < n);
        return n;
    }
}

// Class providing Selection Sort method
class Selection
{
    public static void sort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = a[i];
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (min > a[j]) {
                    min = a[j];
                    index = j;
                }
            }
            int tmp = a[i];
            a[i] = min;
            a[index] = tmp;
        }
    }
}