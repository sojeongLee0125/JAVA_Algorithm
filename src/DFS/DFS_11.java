package DFS;

import java.util.Scanner;

public class DFS_11 {
    static int[][] map;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int count = 0;

    // 나의 답안
    // DFS 돌리면서 섬 하나 발견시 마다 count
    static void dfs(int y, int x) {
        for (int k = 0; k < 8; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (0 <= ny && ny < map.length && 0 <= nx && nx < map[0].length && map[ny][nx] == 1) {
                map[ny][nx] = 2;
                dfs(ny, nx);
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
                    // dfs 한 번 돌때마다 섬이 발견되면서 방문체크 하는 것
                    count++;
                    map[i][j] = 2;
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
    }
}