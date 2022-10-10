package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_3 {
    static ArrayList<problem> list = new ArrayList<>();
    static int answer, m;

    static class problem {
        int score;
        int time;

        public problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    // 부분 집합을 구하고 제한 시간 이내이면 정답값을 갱신한다.
    static void dfs(int cnt, int tSum, int sSum) {
        // base case
        if (cnt == list.size()) {
            if (m >= tSum) {
                answer = Math.max(answer, sSum);
            }
        } else {
            dfs(cnt + 1, tSum + list.get(cnt).time, sSum + list.get(cnt).score);
            dfs(cnt + 1, tSum, sSum);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        m = kb.nextInt();
        for (int i = 0; i < n; i++) {
            int s = kb.nextInt();
            int t = kb.nextInt();
            list.add(new problem(s, t));
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }
}