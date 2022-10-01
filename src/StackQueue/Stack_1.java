package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Stack_1 {
    static String solution(String str) {
        String answer = "NO";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return answer;
                stack.pop();
            }
        }

        if (stack.isEmpty()) return "YES";
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
    }
}