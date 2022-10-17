package DP;

import java.util.Scanner;

public class Dp_1 {
    static int solution(int n) {
        // 첫번째 계단을 올라가는 경우의 수 : 1개
        // 2번째 : 1칸씩 올라가는 방법 + 2칸 올라가는 방법 : 2개
        // 3번째 계단 : 첫번째 계단에서 올라오는 방법 + 두번째 계단에서 올라오는 방법 : 1 + 2 = 3개
        // 4번째 계단 : 두번째 계단에서 올라오는 방법 + 세번째 계단에서 올라오는 방법 : 2 + 3 = 5개
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(solution(n));
    }
}