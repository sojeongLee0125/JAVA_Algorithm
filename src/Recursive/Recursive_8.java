package Recursive;

import java.util.ArrayList;
import java.util.Scanner;

public class Recursive_8 {
    static ArrayList<Integer> answer;
    static boolean[] chk;
    static int cnt;

    // 나의 답안 - 답 리스트도 출력
    static void dfs(int n, int[][] graph, int point) {
        // base case : 정점이 5에 도착하면 출력
        if (point == n) {
            cnt++;
            for (int i : answer) System.out.print(i + " ");
            System.out.println();
            return;
        }

        // 각 정점에서 연결된 다른 정점으로 재귀함수 호출 + 방문체크
        for (int i = 1; i <= n; i++) {
            if (!chk[i] && graph[point][i] == 1) {
                // 정답값 추가 및 방문체크
                answer.add(i);
                chk[i] = true;
                dfs(n, graph, i);
                // 백하면서 방문체크 해제 및 답에서 빼기
                chk[i] = false;
                answer.remove(answer.size() - 1);
            }
        }
    }

    // 강의 답안 - 갯수만 카운트
    static void dfs2(int n, int[][] graph, int point) {
        if (point == n) {
            cnt++;
        }

        for (int i = 1; i <= n; i++) {
            if (!chk[i] && graph[point][i] == 1) {
                chk[i] = true;
                dfs2(n, graph, i);
                chk[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }

        answer = new ArrayList<>();
        chk = new boolean[n + 1];
        answer.add(1);
        chk[1] = true;

        System.out.println("=======================");
        dfs(n, graph, 1);
        System.out.println(cnt);
        System.out.println("=======================");

        System.out.println("=======================");
        cnt = 0;
        dfs2(n, graph, 1);
        System.out.println(cnt);
        System.out.println("=======================");
    }


}