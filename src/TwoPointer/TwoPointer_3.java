package TwoPointer;

import java.util.Scanner;

public class TwoPointer_3 {
    // 나의 답
    static int solution1(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int rt = 0;
        sum += arr[rt];

        while (rt < (n - 1)) {
            if (sum < m) {
                sum += arr[++rt];
                if (sum == m) answer++;
            } else {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }

        return answer;
    }

    // 강의 답안
    static int solution2(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution2(n, m, arr));
    }
}