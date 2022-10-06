package Recursive;

import java.util.Scanner;

public class Recursive_3 {

    // 팩토리얼
    static int recur(int n) {
        // base case
        if (n == 1) return 1;

        //recursive case
        return n * recur(n - 1);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(recur(n));
    }
}