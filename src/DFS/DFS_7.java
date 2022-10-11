package DFS;

import java.util.Scanner;

public class DFS_7 {

    static int[][] chk;

    static int dfs(int n, int r) {
        if (chk[n][r] > 0) return chk[n][r];
        if (r == 0 || r == n) return 1;
        else return chk[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        chk = new int[n + 1][r + 1];
        System.out.println(dfs(n, r));
    }
}