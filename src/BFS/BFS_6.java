package BFS;

import java.util.*;

public class BFS_6 {
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M;
    static List<Point> startList = new ArrayList<>();

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    // 나의 답안

    // 마지막에 검사하는 메서드
    static int chk(int[][] map) {
        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) return -1;
                if (map[i][j] > answer) answer = map[i][j];
            }
        }

        // 처음 시작날짜가 1이므로 하루 빼주어야 한다.
        return answer - 1;
    }

    // 1의 위치를 찾아서 해당 위치부터 BFS 시작
    // BFS 전부를 돌리고 난 뒤 마지막에 검사
    static void bfs() {
        Queue<Point> q = new LinkedList<>();

        // 시작점들 큐에 삽입
        for (Point point : startList) {
            q.offer(point);
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int k = 0; k < 4; k++) {
                int ny = p.y + dy[k];
                int nx = p.x + dx[k];
                if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] == 0) {
                    q.offer(new Point(ny, nx));
                    map[ny][nx] = map[p.y][p.x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        M = kb.nextInt();
        N = kb.nextInt();
        map = new int[N][M];

        int sw = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = kb.nextInt();
                if (map[i][j] == 1) startList.add(new Point(i, j));
                if (map[i][j] == 0) sw += 1;
            }
        }

        // 처음부터 토마토가 다 익어있는 경우 0 출력
        if (sw == 0) System.out.println(0);

        bfs();
        System.out.println(chk(map));
    }
}