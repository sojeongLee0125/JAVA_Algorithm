package DFS;

import java.util.*;

public class DFS_8 {
    static int n, f;
    static boolean[] chk;
    static int[] b;
    static int[] p;
    static int[][] combiArr = new int[35][35];
    static boolean sw;

    static int combi(int n, int r) {
        if (combiArr[n][r] > 0) return combiArr[n][r];
        if (r == 0 || r == n) return 1;
        else return combiArr[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    static void dfs(int cnt, int sum) {
        if (sw) return;
        // 4개 조합 만들어서 검증
        if (cnt == n) {
            if (sum == f) {
                for (int i : p) {
                    System.out.print(i + " ");
                }
                sw = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!chk[i]) {
                    chk[i] = true;
                    p[cnt] = i;
                    dfs(cnt + 1, sum + (p[cnt] * b[cnt]));
                    chk[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        b = new int[n];
        p = new int[n];
        chk = new boolean[n + 1];
        // 각 숫자마다 nC0 / nC1 / ... / nCn-1을 곱해주면서 더해야 한다.
        for (int i = 0; i < n; i++) {
            b[i] = combi(n - 1, i);
        }
        dfs(0, 0);
    }
}