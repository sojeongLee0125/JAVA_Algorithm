package TwoPointer;

import java.util.Scanner;

public class TwoPointer_4 {
    // 나의 답
    static int solution1(int n) {
        int answer = 0;
        int lt = 1;
        int sum = 1;

        for (int rt = 2; rt < n; rt++) {
            sum += rt;
            if (sum == n) answer++;
            while (sum >= n) {
                sum -= lt;
                lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }

    // 강의 답안
    static int solution2(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 1;

        for (int rt = 1; rt <= (n / 2) + 1; rt++) {
            sum += rt;
            if (sum == n) answer++;
            while (sum >= n) {
                sum -= lt++;
                if (sum == n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(solution2(n));
    }
}