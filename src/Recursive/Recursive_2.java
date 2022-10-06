package Recursive;

import java.util.Scanner;

public class Recursive_2 {

    // 2진수 변환
    static void recur(int n) {
        // base case
        if (n == 0) return;

        //recursive case
        recur(n / 2);
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        recur(n);
    }
}