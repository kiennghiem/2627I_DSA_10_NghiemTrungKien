package edu.princeton.cs.algs4.week3;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

/* Y tuong: dung stack. ta co the them bao nhieu ngoac trai vao stack cung duoc. Nhung neu cho ngoac phai vao,
thi phai kiem tra xem no co phai la matching bracket voi ngoac trai nam tren cung cua stack khong.
Neu no ko phai, thi return "NO". Neu no co phai, thi pop ngoac trai tren cung ay ra, va tiep tuc xem xet cac
ngoac moi. Neu da het ky tu, ma stack van con, thi return "NO".
*/

public class BalancedBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {

                if (stack.empty()) return "NO";
                char leftBracket = stack.peek();
                if (c != rightCompany(leftBracket)) return "NO";
                stack.pop();
            }
        }
        if (!stack.empty()) return "NO";
        return "YES";
    }

    public static char rightCompany(char leftBracket) {

        if (leftBracket == '(') return ')';
        else if (leftBracket == '[') return ']';
        else return '}';
    }
}

class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/edu/princeton/cs/algs4/week3/BalancedBracketsResult"));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine().trim();

                String result = BalancedBrackets.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();



    }
}

