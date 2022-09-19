package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Array_6 {

    static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static ArrayList<Integer> solution(int num, int[] nums) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int n : nums) {
            int tmp = 0;
            while (n > 0) {
                tmp = (tmp * 10) + (n % 10);
                n /= 10;
            }
            if (isPrime(tmp)) {
                answer.add(tmp);
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
        for (Integer i : solution(num, nums)) {
            System.out.print(i + " ");
        }
    }
}