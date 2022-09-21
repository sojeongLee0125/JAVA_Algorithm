package Array;

import java.util.Scanner;

public class Array_11 {
    static int solution(int n, int[][] nums) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        // i번 학생 기준
        for (int i = 1; i < n + 1; i++) {
            // i번 학생과 같은 반이었던 학생 수
            int cnt = 0;
            // i번 학생과 비교할 j번 학생
            for (int j = 1; j < n + 1; j++) {
                // 학년별 비교
                for (int k = 1; k < 6; k++) {
                    if (nums[i][k] == nums[j][k]) {
                        cnt++;
                        // 동일한 학생이 다음 학년에서 같은 반일경우 중복 카운트 되므로 방지
                        break;
                    }
                }
            }
            // i번 학생의 cnt 구해짐
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] nums = new int[n + 1][6];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < 6; j++) {
                nums[i][j] = kb.nextInt();
            }
        }
        System.out.print(solution(n, nums));
    }
}