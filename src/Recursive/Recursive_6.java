package Recursive;

import java.util.Scanner;
import java.util.Stack;

public class Recursive_6 {
    static boolean[] chk;
    static Stack<Integer> stack;

    // 내 답안
    static void powerSet(int n, int cnt) {
        if (cnt > n) {
            // 공집합 제외
            if (stack.size() == 0) return;
            // 완성된 부분집합 출력
            for (Integer integer : stack) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }

        stack.push(cnt);
        chk[cnt] = true;
        powerSet(n, cnt + 1);

        stack.pop();
        chk[cnt] = false;
        powerSet(n, cnt + 1);
    }

    // 강의 답안
    static void dfs(int n, int cnt) {
        if (cnt > n) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (chk[i]) tmp += (i + " ");
            }
            if (tmp.length() > 0) System.out.println(tmp);
            return;
        }

        chk[cnt] = true;
        dfs(n, cnt + 1);

        chk[cnt] = false;
        dfs(n, cnt + 1);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        stack = new Stack<>();
        chk = new boolean[n + 1];
        // powerSet(n, 1);
        dfs(n, 1);
    }
}