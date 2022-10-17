package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Dp_3 {
    // 나의 풀이
    static int solution(int[] arr) {
        int[] answer = new int[arr.length];
        Arrays.fill(answer, 1);
        int max = Integer.MIN_VALUE;

        // 앞의 원소들 중 현재 원소보다 작은 값중에 가장 큰 증가값을 가진 요소 + 1을 나의 요소로 가진다.
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    if (answer[j] + 1 > answer[i]) answer[i] = answer[j] + 1;
                }
            }
            if (max < answer[i]) max = answer[i];
        }

        return max;
    }

    // 강의 풀이
    static int solution2(int[] arr) {
        int[] answer = new int[arr.length];
        int result = 0;
        answer[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && answer[j] > max) max = answer[j];
            }
            answer[i] = max + 1;
            result = Math.max(result, answer[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        // System.out.println(solution(arr));
        System.out.println(solution2(arr));
    }
}