package DFS;

import java.util.*;

public class DFS_12 {

    // 1) 피자집들을 ArrayList로 받는다. 집들을 ArrayList로 받는다.
    // 2) M개로 나올 수 있는 조합의 경우의 수를 구한다.
    // 3) M개의 피자집들을 선택한다.(조합)
    // 4) 선택된 피자집과 집들과의 거리를 구한다.
    // 5) sum이 최소일 때의 피자집 리스트와 sum을 저장한다.
    // 6) sum을 출력한다.
    static int N, M;
    static int minSum = Integer.MAX_VALUE;
    static ArrayList<Point> homeList = new ArrayList<>();
    static ArrayList<Point> pizzaList = new ArrayList<>();

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    // 2) M개로 나올 수 있는 조합의 경우의 수를 구한다.
    static int[] combiList;

    static void combi(int cnt, int idx) {
        if (cnt == M) {
            // 조합 하나가 완성됨
            int sum = 0;
            // 집 하나가 선택 된다.
            for (Point h : homeList) {
                int dis = Integer.MAX_VALUE;
                for (int i : combiList) {
                    dis = Math.min(dis, Math.abs(h.x - pizzaList.get(i).x) + Math.abs(h.y - pizzaList.get(i).y));
                }
                sum += dis;
            }
            minSum = Math.min(minSum, sum);
        } else {
            for (int i = idx; i < pizzaList.size(); i++) {
                combiList[cnt] = i;
                combi(cnt + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        // 1) 피자집들을 ArrayList로 받는다. 집들을 ArrayList로 받는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = kb.nextInt();
                if (x == 1) homeList.add(new Point(i, j));
                else if (x == 2) pizzaList.add(new Point(i, j));
            }
        }
        combiList = new int[M];
        combi(0, 0);

        System.out.println(minSum);
    }
}