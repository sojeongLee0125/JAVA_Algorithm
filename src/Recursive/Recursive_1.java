package Recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Recursive_1 {

    static void dfs(int n) {
        // base case
        if (n == 0) return;

        // recursive case
        System.out.print("내림차순 출력 : " + n + " ");
        dfs(n - 1);
        System.out.print("오름차순 출력 : " + n + " ");
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dfs(n);
    }
}