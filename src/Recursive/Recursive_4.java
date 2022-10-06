package Recursive;

import java.util.Scanner;

public class Recursive_4 {

    static int[] fiboArr;

    static int fibo(int n) {
        // base case
        if (fiboArr[n] != 0) return fiboArr[n];
        if (n == 1) return fiboArr[1] = 1;
        if (n == 2) return fiboArr[2] = 1;

        //recursive case
        return fiboArr[n] = fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        fiboArr = new int[n + 1];
        fibo(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fiboArr[i] + " ");
        }
    }
}