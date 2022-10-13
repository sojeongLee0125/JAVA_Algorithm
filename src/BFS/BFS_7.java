package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_7 {
    static int[][] map;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int count = 0;

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    // 나의 답안
    // BFS 돌리면서 섬 하나 발견시 마다 count
    static void bfs(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        // 시작점들 큐에 삽입
        q.offer(new Point(y, x));

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int k = 0; k < 8; k++) {
                int ny = p.y + dy[k];
                int nx = p.x + dx[k];
                if (0 <= ny && ny < map.length && 0 <= nx && nx < map[0].length && map[ny][nx] == 1) {
                    map[ny][nx] = 2;
                    q.offer(new Point(ny, nx));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = kb.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    // bfs 한 번 돌때마다 섬이 발견되면서 방문체크 하는 것
                    count++;
                    map[i][j] = 2;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
    }
}