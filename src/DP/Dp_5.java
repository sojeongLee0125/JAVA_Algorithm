package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Dp_5 {
    // 냅색 알고리즘
    // 금액만큼의 크기 배열을 만든다.
    // 동전으로 만들 수 있는 갯수를 채워넣는다.
    // [i-동전금액크기] + 1
    static int solution(int[] coins, int target) {
        int[] answer = new int[target + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                answer[i] = Math.min(answer[i], answer[i - coin] + 1);
            }
        }

        return answer[target];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = kb.nextInt();
        }
        int target = kb.nextInt();
        System.out.println(solution(coins, target));
    }
}