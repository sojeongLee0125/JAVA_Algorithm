package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_4 {

    // 나의 답안
    static ArrayList<Integer> answer = new ArrayList<>();

    static void dfs(int n, int m, int cnt) {
        // base case
        if (cnt == m) {
            for (Integer integer : answer) {
                System.out.print(integer + " ");
            }
            System.out.println();
        } else {
            // n 가닥으로 뻗어나가야 한다.
            for (int i = 1; i <= n; i++) {
                answer.add(i);
                dfs(n, m, cnt + 1);
                answer.remove(answer.size() - 1);
            }
        }
    }

    // 강의 답안
    static int[] result;

    static void dfs2(int n, int m, int cnt) {
        // base case
        if (cnt == m) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            // n 가닥으로 뻗어나가야 한다.
            for (int i = 1; i <= n; i++) {
                result[cnt] = i;
                dfs2(n, m, cnt + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        dfs(n, m, 0);

        // 강의 답안
        System.out.println("==================");
        result = new int[m];
        dfs2(n, m, 0);
    }
}