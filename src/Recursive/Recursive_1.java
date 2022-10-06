package Recursive;

import java.util.Scanner;

public class Recursive_1 {

    static void dfs(int n) {
        // base case
        if (n == 0) return;

        // recursive case
        System.out.print(n + " "); // 내림차순 출력시 위치
        dfs(n - 1);
        System.out.print(n + " "); // 오름차순 출력시 위치
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dfs(n);
    }
}