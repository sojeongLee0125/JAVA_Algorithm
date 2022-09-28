package TwoPointer;

import java.util.Scanner;

public class TwoPointer_5 {
    // 나의 답
    static int solution1(int n, int k, int[] nums) {
        int answer = 0;
        int cnt = 0;
        int lt = 0;

        for (int rt = 0; rt < nums.length; rt++) {
            if (nums[rt] == 1) {
                cnt++;
                answer = Math.max(answer, cnt);
            } else {
                if (k > 0) {
                    k--;
                    cnt++;
                    answer = Math.max(answer, cnt);
                } else {
                    while (nums[lt] != 0) {
                        lt++;
                        cnt--;
                    }
                    // 발견한 0 한 칸 앞으로 이동
                    lt++;
                }
            }
        }
        return answer;
    }

    // 강의 답안
    static int solution2(int n, int k, int[] nums) {
        int answer = 0;
        int cnt = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if (nums[rt] == 0) cnt++;
            while (cnt > k) {
                if (nums[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = kb.nextInt();
        }
        System.out.println(solution2(n, k, nums));
    }
}