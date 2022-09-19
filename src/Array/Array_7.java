package Array;

import java.util.Scanner;

public class Array_7 {

    static int solution1(int num, int[] nums) {
        int answer = 0;
        int[] scoreList = new int[num];
        scoreList[0] = nums[0];

        for (int i = 1; i < num; i++) {
            if (nums[i] == 0) {
                scoreList[i] = 0;
            } else {
                scoreList[i] = scoreList[i - 1] + 1;
            }
        }

        for (int i : scoreList) {
            answer += i;
        }

        return answer;
    }

    static int solution2(int num, int[] nums) {
        int answer = 0;
        int cnt = 0;

        for (int i = 0; i < num; i++) {
            if (nums[i] == 0) {
                cnt = 0;
            } else {
                cnt++;
                answer += cnt;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int nums[] = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = kb.nextInt();
        }
        System.out.print(solution2(num, nums));
    }
}