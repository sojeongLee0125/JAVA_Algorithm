package Array;

import java.util.Scanner;

public class Array_8 {
    static int[] solution(int num, int[] nums) {
        int[] answer = new int[num];
        for (int i = 0; i < num; i++) {
            int cnt = 1;
            for (int j = 0; j < num; j++) {
                if (nums[i] < nums[j]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
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
        for (int i : solution(num, nums)) {
            System.out.print(i + " ");
        }
    }
}