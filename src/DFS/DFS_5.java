package DFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DFS_5 {

    // 나의 정답
    static int solution(int n, int m, Integer[] coins) {
        // 금액 배열을 생성한 후 해당 금액 동전으로 만들수있는 배열 금액 채운다.
        // 다음 동전은 현재 배열값과 배열 인덱스 - 동전금액값 중 최소값으로 갱신한다.
        int[] result = new int[m + 1];
        Arrays.fill(result, 1000);
        result[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j < result.length; j++) {
                result[j] = Math.min(result[j - coin] + 1, result[j]);
            }
        }

        return result[m];
    }

    // 강의 정답 - dfs
    static int answer = Integer.MAX_VALUE;

    static void dfs(int cnt, int sum, int m, Integer[] coins) {
        if (sum > m) return;
        if (cnt >= answer) return;
        if (sum == m) {
            answer = Math.min(answer, cnt);
        } else {
            for (int i = 0; i < coins.length; i++) {
                dfs(cnt + 1, sum + coins[i], m, coins);
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        System.out.println(solution(n, m, coins));

        // 시간 복잡도 감소 - 큰 금액부터 적용
        Arrays.sort(coins, Collections.reverseOrder());
        dfs(0, 0, m, coins);
        System.out.println(answer);
    }
}