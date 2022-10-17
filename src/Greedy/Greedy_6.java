package Greedy;

import java.util.Scanner;

public class Greedy_6 {
    static int[] arr;
    static int find(int v) {
        if (arr[v] == v) return v;
        // 경로 압축 최종 경로를 저장하면서 리턴하게 된다.
        else return arr[v] = find(arr[v]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) arr[a] = b;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            union(a, b);
        }
        int target1 = kb.nextInt();
        int target2 = kb.nextInt();

        if (find(target1) == find(target2)) System.out.println("YES");
        else System.out.println("NO");
    }
}