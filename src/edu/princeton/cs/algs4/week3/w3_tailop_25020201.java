package edu.princeton.cs.algs4.week3;

import java.util.Stack;

public class w3_tailop_25020201 {

    // Function to return precedence of operators
    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    // Function to check if operator is right-associative
    static boolean isRightAssociative(char c) {
        return c == '^';
    }

    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If operand, add to result
            if ((c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z') ||
                    (c >= '0' && c <= '9'))
                res.append(c);

                // If '(', push to stack
            else if (c == '(')
                st.push('(');

                // If ')', pop until '( '
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            }

            // If operator
            else {
                while (!st.isEmpty() && st.peek() != '(' &&
                        (prec(st.peek()) > prec(c) ||
                                (prec(st.peek()) == prec(c) && !isRightAssociative(c)))) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }

        // Pop remaining operators
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String exp1 = "a*(b+c)/d";
        System.out.println(infixToPostfix(exp1));
        String exp2 = "a+b*c-d";
        System.out.println(infixToPostfix(exp2));
        String exp3 = "a^b/c+d";
        System.out.println(infixToPostfix(exp3));
        String exp4 = "a+(b-c)^d";
        System.out.println(infixToPostfix(exp4));
        String exp5 = "(a+b*c)/d^e";
        System.out.println(infixToPostfix(exp5));
    }
}