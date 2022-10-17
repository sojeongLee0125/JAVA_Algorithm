package Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// 나의 풀이
public class Greedy_7_1 {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<ArrayList<Node>> map = new ArrayList<>();
    static int answer;
    static boolean[] chk;
    static class Node implements Comparable<Node> {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    // 시작점을 pq에 넣는다. 연결된 노드들을 pq에 넣는다.
    // 방문하지 않은 최소 비용 노드를 꺼낸다. 방문 체크를 한다. 비용을 추가한다.
    // 연결된 노드들 중 방문하지 않은 노드를 pq에 넣는다.
    // 다시 pq에서 꺼낸다. 반복한다.
    static void solution() {
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!chk[cur.num]) {
                chk[cur.num] = true;
                answer += cur.cost;
                for (Node n : map.get(cur.num)) {
                    if (!chk[n.num]) pq.offer(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int v = kb.nextInt();
        int e = kb.nextInt();
        chk = new boolean[v + 1];

        for (int i = 0; i <= v; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int cost = kb.nextInt();
            map.get(a).add(new Node(b, cost));
            map.get(b).add(new Node(a, cost));
        }

        solution();

        System.out.println(answer);

    }
}