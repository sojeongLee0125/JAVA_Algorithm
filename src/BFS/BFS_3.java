package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_3 {
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
    static int bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        //root 노드 삽입
        q.add(node);
        int L = 0;
        // 거리찾기 시작
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                if (cur.rt == null && cur.lt == null) {
                    return L;
                }
                if (cur.lt != null) {
                    q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    q.offer(cur.rt);
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        // 트리 세팅
        Node root = new Node(1);
        root.lt = new Node(2);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt = new Node(3);

        // 순회 시작
        System.out.println(bfs(root));
    }
}