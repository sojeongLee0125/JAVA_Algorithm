package BFS;

import java.util.*;

public class BFS_4 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static HashMap<Integer, Integer> answer = new HashMap<>();
    static boolean[] chk;

    // 나의 답안
    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        // 시작점 큐 입력 및 방문체크
        q.add(n);
        chk[n] = true;
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            // 현재 레벨 노드들 탐색
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                // 현재 레벨에서 연결된 노드들 탐색
                for (int nx : graph.get(cur)) {
                    if (!chk[nx]) {
                        answer.put(nx, L + 1);
                        chk[nx] = true;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }
    }

    // 강의 답안 - 정답 배열 사용
    static int[] dis;

    static void bfs2(int n) {
        Queue<Integer> q = new LinkedList<>();
        chk[n] = true;
        dis[n] = 0;
        q.offer(n);

        while (!q.isEmpty()) {
            int cv = q.poll();
            for (int nv : graph.get(cv)) {
                if (!chk[nv]) {
                    chk[nv] = true;
                    q.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        chk = new boolean[n + 1];
        dis = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }

        bfs(1);
        chk = new boolean[n + 1];
        bfs2(1);

        // 나의 답안 정답 출력
        Set<Integer> keySet = answer.keySet();
        for (Integer integer : keySet) {
            System.out.println(integer + " : " + answer.get(integer));
        }

        System.out.println("=======================================");

        // 강의 답안 정답 출력
        for (int i = 2; i < dis.length; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}