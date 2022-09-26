package SlidingWindow;

import java.util.Scanner;

public class SlidingWindow_1 {

    static int solution(int n, int k, int[] arr) {
        int sum = 0;
        int max = 0;

        // 최초 k일간 매출기록 구하기
        for (int i = 0; i < k; i++) {
            sum += arr[i];
            max = sum;
        }

        // 다음날 더하고, 이전날 빼며 최댓값 갱신
        for (int i = k; i < n; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            // sum += (arr[i]-arr[i-k])
            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution(n, k, arr));
    }
}