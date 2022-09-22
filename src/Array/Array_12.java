package Array;

import java.util.Scanner;

public class Array_12 {
    static int solution1(int s, int t, int[][] nums) {
        int answer = 0;

        // 첫번째 테스트에서 첫번쩨 학생을 고른다.
        for (int i = 0; i < s; i++) {
            int first = nums[0][i];
            // 첫번째 학생 이후의 두번째 학생을 고른다.
            for (int j = i + 1; j < s; j++) {
                int second = nums[0][j];
                int cnt = 1;
                // 다음 테스트들에서의 첫번째 학생과 두번째 학생의 인덱스를 비교한다.
                for (int k = 1; k < t; k++) {
                    int fIdx = 0;
                    int sIdx = 0;
                    for (int l = 0; l < s; l++) {
                        if (nums[k][l] == first) fIdx = l;
                        if (nums[k][l] == second) sIdx = l;
                    }
                    if (fIdx < sIdx) cnt++;
                }
                if (cnt == t) answer++;
            }
        }
        return answer;
    }

    static int solution2(int s, int t, int[][] nums) {
        int answer = 0;
        // 첫번째 테스트에서 첫번쩨 학생을 고른다.
        for (int i = 1; i <= s; i++) {
            // 두번째 학생을 고른다.
            for (int j = 1; j <= s; j++) {
                int cnt = 0;
                // 다음 테스트들에서의 첫번째 학생과 두번째 학생의 인덱스를 비교한다.
                for (int k = 0; k < t; k++) {
                    int fIdx = 0;
                    int sIdx = 0;
                    for (int x = 0; x < s; x++) {
                        if (nums[k][x] == i) {
                            fIdx = x;
                        }
                        if (nums[k][x] == j) {
                            sIdx = x;
                        }
                    }
                    if (fIdx < sIdx) cnt++;
                }
                if (cnt == t) answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt(); // 학생수
        int t = kb.nextInt(); // 테스트수
        int[][] nums = new int[t][s];
        for (int i = 0; i < t; i++) { //3
            for (int j = 0; j < s; j++) { //4
                nums[i][j] = kb.nextInt();
            }
        }
        System.out.print(solution1(s, t, nums));
    }
}