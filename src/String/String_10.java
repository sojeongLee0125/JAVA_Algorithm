package String;

import java.util.Scanner;

public class String_10 {
    static int[] solution(char c, String str) {
        int len = str.length();
        int[] answer = new int[len];
        int cnt = 1000;

        // 왼쪽 타겟 문자로부터의 거리 구하기
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == c) {
                cnt = 0;
                answer[i] = 0;
            } else {
                cnt++;
                answer[i] = cnt;
            }
        }

        cnt = 1000;

        // 오른쪽 타겟 문자로부터의 거리 구하기
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                cnt = 0;
            } else {
                cnt++;
                answer[i] = Math.min(answer[i], cnt);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        for (int i : solution(c, str)) {
            System.out.print(i + " ");
        }
    }
}
