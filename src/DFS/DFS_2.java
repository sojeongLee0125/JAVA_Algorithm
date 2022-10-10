package DFS;

import java.util.Scanner;

public class DFS_2 {
    static int[] arr;
    static int c, answer;

    // 나의 정답
    // 요소를 집합에 포함하는 경우 / 포함하지 않는 경우
    // cnt 완성 시 합을 구하고 c 보다 작으면 answer에 갱신한다.
    static void dfs(int cnt, int sum) {
        // base case
        if (sum > c) return;
        if (cnt == arr.length) {
            if (sum <= c) {
                answer = Math.max(answer, sum);
            }
        } else {
            dfs(cnt + 1, sum + arr[cnt]);
            dfs(cnt + 1, sum);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        int n = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        dfs(0, 0);
        System.out.println(answer);
    }
}