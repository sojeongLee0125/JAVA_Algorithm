package Recursive;

public class Recursive_7 {
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

    static int dfs(Node node, int L) {
        if (node.lt == null && node.rt == null) return L;
        else return Math.min(dfs(node.lt, L + 1), dfs(node.rt, L + 1));
    }

    public static void main(String[] args) {
        // 트리 세팅
        Node root = new Node(1);
        root.lt = new Node(2);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt = new Node(3);

        // 순회 시작
        System.out.println(dfs(root, 0));
    }
}