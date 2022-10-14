package DFS;

import java.util.*;

public class DFS_12 {

    // 1) 피자집들을 ArrayList로 받는다. 집들을 ArrayList로 받는다.
    // 2) M개로 나올 수 있는 조합의 경우의 수를 구한다.
    // 3) 현재 집을 기준으로 조합된 피자집 리스트들과의 거리를 구한다.(피자집들과의 거리 중 최소값을 저장한다.)
    // 4) 도시의 피자집 거리를 구한다.(sum)
    // 5) minSum과 sum을 비교 후 최소값을 업데이트 한다.
    static int N, M;
    static int minSum = Integer.MAX_VALUE;
    static ArrayList<Point> pz = new ArrayList<>();
    static ArrayList<Point> hm = new ArrayList<>();
    static int[] combi;

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void DFS(int L, int idx) {
        if (L == M) {
            // 조합 완성
            // 집 하나를 선택
            int sum = 0;
            for (Point h : hm) {
                // 집 하나의 피자집들과의 최소배달거리 구하기
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    Point tmpPz = pz.get(i);
                    dis = Math.min(dis, Math.abs(h.x - tmpPz.x) + Math.abs(h.y - tmpPz.y));
                }
                // 도시의 피자배달거리 구하기
                sum += dis;
            }
            minSum = Math.min(minSum, sum);
        } else {
            for (int i = idx; i < pz.size(); i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        // 집 좌표 리스트 및 피자집 좌표 리스트 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = kb.nextInt();
                if (tmp == 1) hm.add(new Point(i, j));
                if (tmp == 2) pz.add(new Point(i, j));
            }
        }

        combi = new int[M];
        DFS(0, 0);
        System.out.println(minSum);
    }
}