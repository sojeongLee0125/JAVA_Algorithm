package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_1 {
    static class Node {
        int value;
        Node rt;
        Node lt;

        public Node(int value) {
            this.value = value;
            this.rt = null;
            this.lt = null;
        }
    }

    // 나의 답안
    static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        //root 노드 삽입
        q.add(node);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.value + " ");
            if (cur.lt != null) {
                q.offer(cur.lt);
            }
            if (cur.rt != null) {
                q.offer(cur.rt);
            }
        }
    }

    // 강의 답안
    static void bfs2(Node node) {
        Queue<Node> q = new LinkedList<>();
        //root 노드 삽입
        q.offer(node);
        // 레벨값
        int L = 0;
        // 큐 반복 시작
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(L + ":");
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                // 현재 노드 출력
                System.out.print(cur.value + " ");
                // 연결된 노드 입력
                if (cur.lt != null) q.offer(cur.lt);
                if (cur.rt != null) q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 트리 세팅
        Node root = new Node(1);
        root.lt = new Node(2);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt = new Node(3);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        // 순회 시작
        bfs(root);
        System.out.println();
        bfs2(root);
    }
}