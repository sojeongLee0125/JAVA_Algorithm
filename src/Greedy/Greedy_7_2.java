package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_7_2 {
    static int[] arr;
    static int answer;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static class Node implements Comparable<Node> {
        int v1;
        int v2;
        int cost;

        public Node(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }

    static int find(int v) {
        if (arr[v] == v) return v;
        else return arr[v] = find(arr[v]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) arr[fa] = fb;
    }

    static void solution() {
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                cnt++;
                answer += cur.cost;
            }
            // 간선의 갯수는 v갯수 -1개이므로 트리가 완성되면 break
            if (cnt == arr.length - 2) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int v = kb.nextInt();
        int e = kb.nextInt();
        arr = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int v1 = kb.nextInt();
            int v2 = kb.nextInt();
            int cost = kb.nextInt();
            pq.offer(new Node(v1, v2, cost));
        }

        solution();
        System.out.println(answer);
    }
}