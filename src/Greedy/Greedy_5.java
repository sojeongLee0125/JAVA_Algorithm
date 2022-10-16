package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_5 {
    static ArrayList<ArrayList<Node>> map = new ArrayList<>();
    static int[] dis;

    static class Node implements Comparable<Node> {
        int value;
        int cost;

        public Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static void solution() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dis[1] = 0;

        while (!pq.isEmpty()) {
            // 현재 비용이 가장 작은 노트 뽑기
            Node node = pq.poll();
            // 이미 방문한 노드의 경우 pass
            if (dis[node.value] < node.cost) continue;
            // 연결 노드 순회
            for (Node n : map.get(node.value)) {
                if (dis[n.value] > dis[node.value] + n.cost) {
                    dis[n.value] = dis[node.value] + n.cost;
                    pq.offer(new Node(n.value, dis[n.value]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int st = kb.nextInt();
            int ed = kb.nextInt();
            int cost = kb.nextInt();
            map.get(st).add(new Node(ed, cost));
        }

        solution();

        for (int i = 2; i < dis.length; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else {
                System.out.println(i + " : impossible");
            }
        }
    }
}