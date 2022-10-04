package SortingSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sorting_4 {
    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x != o.x) return this.x - o.x;
            else return this.y - o.y;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            points.add(new Point(x, y));
        }
        Collections.sort(points);
        for (Point point : points) {
            System.out.println(point);
        }

    }
}