package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Stack_4 {
    public static int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        // str을 순회하면서 숫자면 push
        // 연산자가 나오면 숫자 2개를 pop해서 연산 한 뒤에 다시 stack에 push
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int tmp2 = stack.pop();
                int tmp1 = stack.pop();
                int result = 0;
                switch (c) {
                    case '+':
                        result = tmp1 + tmp2;
                        break;
                    case '-':
                        result = tmp1 - tmp2;
                        break;
                    case '*':
                        result = tmp1 * tmp2;
                        break;
                    case '/':
                        result = tmp1 / tmp2;
                        break;
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
    }
}