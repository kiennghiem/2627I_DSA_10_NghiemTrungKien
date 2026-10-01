package edu.princeton.cs.algs4.week3;

import java.io.*;
import java.util.*;
import java.util.Scanner;

/*
stack1 is used for enqueue, stack2 is used for dequeue and peek.
Top element of stack1 is the tail of the queue, top element of stack2 is head of the queue.
If stack2 is not empty, dequeue and peek will work with the top of stack2.
If stack2 is empty, dequeue and peek will move all elements from stack1 to stack2, and then the top
of stack2 will be worked on.
*/

public class QueueUsingTwoStacks {

    public static void main(String[] args) throws IOException {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int queryNum = s.nextInt();

            if (queryNum == 1) {
                int enq = s.nextInt();
                stack1.push(enq);
            } else {
                if (stack2.empty()) {
                    while (!stack1.empty()) {
                        stack2.push(stack1.pop());
                    }
                }
                if (queryNum == 2) {
                    stack2.pop();
                } else {
                    System.out.println(stack2.peek());
                }
            }
        }
        s.close();
    }
}