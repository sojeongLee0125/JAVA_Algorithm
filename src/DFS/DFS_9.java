package DFS;

import java.util.Scanner;

public class DFS_9 {
    static int[] result;

    static void dfs(int n, int m, int cnt, int s) {
        if (cnt == m) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                result[cnt] = i;
                dfs(n, m, cnt + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        result = new int[m];
        dfs(n, m, 0, 1);
    }
}