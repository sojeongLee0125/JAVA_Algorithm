package BFS;

import java.util.*;

public class BFS_5 {
    static int[][] map = new int[8][8];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    // 나의 답안
    static int bfs(int y, int x) {
        int cnt = 0;
        Queue<Point> q = new LinkedList<>();
        Point point = new Point(y, x);
        q.add(point);

        // q에 넣고 돌린다. 7,7에 도착했을 경우 return
        while (!q.isEmpty()) {
            int size = q.size();
            // 거리별 순회
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                for (int k = 0; k < 4; k++) {
                    int ny = p.y + dy[k];
                    int nx = p.x + dx[k];
                    if (ny == 7 && nx == 7) return cnt + 1;
                    if (1 <= ny && ny <= 7 && 1 <= nx && nx <= 7 && map[ny][nx] == 0) {
                        map[ny][nx] = 1;
                        q.add(new Point(ny, nx));
                    }
                }
            }
            // 현재 레벨 순회 완료
            cnt++;
        }
        return -1;
    }

    // 강의 답안 - dis 배열 사용
    static int[][] dis = new int[8][8];

    static void bfs2(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x));
        map[y][x] = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int k = 0; k < 4; k++) {
                int ny = p.y + dy[k];
                int nx = p.x + dx[k];
                if (1 <= ny && ny <= 7 && 1 <= nx && nx <= 7 && map[ny][nx] == 0) {
                    map[ny][nx] = 1;
                    q.offer(new Point(ny, nx));
                    dis[ny][nx] = dis[p.y][p.x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = kb.nextInt();
            }
        }
        // 나의 답안
        System.out.println(bfs(1, 1));

        // 강의 답안
        bfs2(1, 1);
        if (dis[7][7] != 0) System.out.println(dis[7][7]);
        else System.out.println(-1);
    }
}