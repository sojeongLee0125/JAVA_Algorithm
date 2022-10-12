package DFS;

import java.util.Scanner;

public class DFS_10 {
    static int[][] map = new int[7][7];
    static int count;
    // 상 오 아 왼
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x) {
        if (x == 6 && y == 6) {
            count++;
        } else {
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0 <= ny && ny < 7 && 0 <= nx && nx < 7 && map[ny][nx] == 0) {
                    map[ny][nx] = 2;
                    dfs(ny, nx);
                    map[ny][nx] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = kb.nextInt();
            }
        }
        map[0][0] = 1;
        dfs(0, 0);
        System.out.println(count);
    }
}