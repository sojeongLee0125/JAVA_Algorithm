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

    // 강의 답안 1
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

    // 강의 답안 2 - 수학적인 풀이법
    static int solution3(int n) {
        int answer = 0;


        // 미리 n을 나눌 숫자 갯수만큼 1+2+3.. 으로 할당
        // 할당된 숫자의 합을 n에서 빼고 뺀 값을 나눈 숫자 갯수로 분배
        // 15를 3개로 나눔 => 1+2+3 미리 할당 =>
        // 15-(1+2+3) = 9 => 9를 3으로 나눠서 3군데 할당
        // => 1+3/2+3/3+3 (4+5+6)

        int cnt = 1;
        n--; // 먼저 1 제외
        while (n > 0) {
            // cnt가 연속된 자연수의 갯수이다.
            cnt++;
            n = n - cnt; // 2제외, 3제외 ...
            if (n % cnt == 0) answer++;
            // n에서 1과 2를 뺀 다음 2로 나누어지면 할당 가능
            // n에서 1과 2와 3을 뺀 다음 3으로 나누어지면 할당 가능...
        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(solution2(n));
    }
}