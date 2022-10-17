package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dp_4 {
    // 밑면과 무게를 기준으로 오름차순 정렬한다.
    // LIS를 구한다.
    static ArrayList<Brick> bricks = new ArrayList<>();
    static class Brick implements Comparable<Brick> {
        int width;
        int height;
        int weight;

        public Brick(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return this.width - o.width;
        }
    }

    static int solution() {
        int[] dy = new int[bricks.size()];
        dy[0] = bricks.get(0).height;
        int answer = dy[0];

        for (int i = 1; i < bricks.size(); i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (bricks.get(i).weight > bricks.get(j).weight && max < dy[j]) max = dy[j];
            }
            dy[i] = max + bricks.get(i).height;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for (int i = 0; i < n; i++) {
            int wid = kb.nextInt();
            int h = kb.nextInt();
            int w = kb.nextInt();
            bricks.add(new Brick(wid, h, w));
        }
        Collections.sort(bricks);
        System.out.println(solution());
    }
}