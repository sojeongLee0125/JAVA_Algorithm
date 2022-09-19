package Array;

import java.util.Enumeration;
import java.util.Scanner;

public class Array_5 {

    static int solution(int num) {
        int answer = 0;
        int[] nums = new int[num + 1];
        for (int i = 2; i <= num; i++) {
            if (nums[i] == 0) {
                answer++;
                for (int j = i; j <= num; j += i) {
                    nums[j] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        System.out.print(solution(num));
    }
}
