package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_2 {
    // 나의 답안
    // 처음 위치를 q에 넣는다.
    // 현재 위치 다음 값들을 q에 넣고 방문체크.
    // 이후 q에서 현재 레벨 모두 꺼내면서 검사한다.
    // 맞으면 레벨 return
    // 맞지 않으면 다음 레벨에 갈 수 있는 값들을 갱신해서 방문체크하고 q에 넣는다.
    static int solution(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] chk = new boolean[20000];
        int[] next = {1, -1, 5};
        int L = 0;

        q.offer(s);
        chk[s] = true;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                // 현재 레벨의 값들을 꺼내서 정답과 비교
                int cur = q.poll();
                if (cur == e) return L;
                // 정답이 아닐 경우 현재 레벨의 값들을 그 다음 레벨의 값들을 갱신 후 큐에 삽입
                for (int j = 0; j < next.length; j++) {
                    int nextPoint = cur + next[j];
                    if (nextPoint < 0) continue;
                    if (!chk[nextPoint]) {
                        q.offer(nextPoint);
                        chk[nextPoint] = true;
                    }
                }
            }
            L++;
        }
        return 0;
    }

    // 강의 답안
    static int solution2(int s, int e) {
        int answer = 0;
        int[] next = {1, -1, 5};
        boolean[] chk = new boolean[10001];
        Queue<Integer> q = new LinkedList<>();

        q.offer(s);
        chk[s] = true;
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                for (int j = 0; j < next.length; j++) {
                    int nextPoint = cur + next[j];
                    if (nextPoint == e) return L + 1;
                    if (nextPoint >= 1 && nextPoint <= 10001 && !chk[nextPoint]) {
                        chk[nextPoint] = true;
                        q.offer(nextPoint);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(solution2(s, e));
    }
}