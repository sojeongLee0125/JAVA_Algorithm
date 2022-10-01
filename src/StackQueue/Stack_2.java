package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Stack_2 {
    // 나의 답안
    static String solution1(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        // 문자열을 돌면서 문자일 경우 스택이 비어있으면 정답에 추가
        // ( 만나면 push, ) 만나면 pop
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (stack.isEmpty()) answer += c;
            } else if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return answer;
    }

    // 강의 답안
    static String solution2(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        // 전부 다 스택에 집어넣고 닫는 문자일 경우 여는 문자 전까지 다 뺀다.
        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(') ;
            } else stack.push(c);
        }

        // 스택에 남은 문자열만 출력
        for (Character character : stack) {
            answer += character;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution2(str));
    }
}