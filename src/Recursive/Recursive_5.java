package Recursive;

public class Recursive_5 {
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

    static void dfs(Node node) {
        if (node == null) return;
        // 전위 순회 System.out.print(node.value + " ");
        dfs(node.lt);
        // 중위 순회 System.out.print(node.value + " ");
        dfs(node.rt);
        // 후위 순회 System.out.print(node.value + " ");
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
        dfs(root);
    }
}