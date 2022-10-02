package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Stack_5 {
    // 나의 답안
    // (를 입력받으면 stack에 push, 막대기 갯수 증가
    // )를 입력받으면 - 레이저일 경우 / 막대기 끝일 경우
    // 1) 레이저일 경우 : 막대 갯수 1개 제거 후 현재 막대기 갯수만큼 조각 갯수 증가 그리고 ) 삽입
    // 2) 막대기 끝일 경우 : 막대 갯수 1개 감소 후 조각 갯수 1개 증가 그리고 ) 삽입
    public static int solution1(String str) {
        int answer = 0;
        int num = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                num++;
            } else {
                num--;
                if (stack.peek() == '(') {
                    // 레이저 일 경우
                    answer += num;
                } else {
                    // 막대의 끝일 경우
                    answer += 1;
                }
                stack.push(c);
            }
        }

        return answer;
    }

    // 강의  답안
    public static int solution2(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push(str.charAt(i));
            else {
                stack.pop();
                if (str.charAt(i - 1) == '(') answer += stack.size();
                else answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution2(str));
    }
}