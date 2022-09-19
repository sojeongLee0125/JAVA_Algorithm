package Array;

import java.util.Scanner;

public class Array_4 {
    static int[] solution1(int num) {
        int[] answer = new int[num];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < num; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        return answer;
    }

    static void solution2(int num) {
        int a = 1;
        int b = 1;
        System.out.print(a + " " + b + " ");
        int c = 0;
        for (int i = 2; i < num; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        // solution1 출력
        for (int i : solution1(num)) {
            System.out.print(i + " ");
        }

        // solution2 출력 - 손코딩 연습문제
        System.out.println();
        solution2(num);
    }
}
