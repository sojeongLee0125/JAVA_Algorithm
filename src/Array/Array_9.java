package Array;

import java.util.Scanner;

public class Array_9 {
    static int solution(int n, int[][] scores) {
        int answer = Integer.MIN_VALUE;
        int sum1;
        int sum2;

        // 행과 열의 합 최대값 구하기
        for (int i = 0; i < n; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += scores[i][j];
                sum2 += scores[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        // 대각선의 합 구하기
        sum1 = 0;
        sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += scores[i][i];
            sum2 += scores[i][n - i - 1];
        }
        answer = Math.max(sum1, answer);
        answer = Math.max(sum2, answer);

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int scores[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                scores[i][j] = kb.nextInt();
            }
        }
        System.out.print(solution(n, scores));
    }
}