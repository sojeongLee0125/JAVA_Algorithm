package Recursive;

import java.util.ArrayList;
import java.util.Scanner;

public class Recursive_9 {
    static ArrayList<ArrayList<Integer>> answer;
    static ArrayList<Integer> result = new ArrayList<>();
    static boolean[] chk;
    static int cnt;

    static void dfs(int n, int point) {
        // base case : 정점이 5에 도착하면 출력
        if (point == n) {
            cnt++;
            for (int i : result) System.out.print(i + " ");
            System.out.println();
            return;
        }

        // 각 정점에서 연결된 다른 정점으로 재귀함수 호출 + 방문체크
        for (int cur : answer.get(point)) {
            if (!chk[cur]) {
                chk[cur] = true;
                result.add(cur);
                dfs(n, cur);
                chk[cur] = false;
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        answer = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            answer.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            answer.get(a).add(b);
        }

        chk = new boolean[n + 1];
        chk[1] = true;
        result.add(1);
        dfs(n, 1);
        System.out.println(cnt);
    }
}