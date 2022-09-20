package Array;

import java.util.Scanner;

public class Array_10 {
    static int solution(int n, int[][] nums) {
        int answer = 0;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                        if (nums[ny][nx] >= nums[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = kb.nextInt();
            }
        }
        System.out.print(solution(n, nums));
    }
}