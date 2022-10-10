package DFS;

import java.util.Scanner;

public class DFS_6 {
    static int[] answer;
    static boolean[] chk;

    static void dfs(int n, int m, int[] arr, int cnt) {
        if (cnt == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!chk[i]) {
                    answer[cnt] = arr[i];
                    chk[i] = true;
                    dfs(n, m, arr, cnt + 1);
                    chk[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        answer = new int[m];
        chk = new boolean[n];
        dfs(n, m, arr, 0);
    }
}