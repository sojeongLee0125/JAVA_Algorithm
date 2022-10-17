package DP;

import java.util.Scanner;

public class Dp_2 {
    // 돌다리가 0개일 경우 : 1번에 건너는 경우 1가지
    // 돌다리가 1개일 경우 : 1칸씩 가는 경우 + 2칸을 한번에 건너는 경우 : 2가지
    // 돌다리가 2개일 경우 : 1칸씩 가는 경우 + 1칸 & 2칸으로 건너는 경우 + 2칸 & 1칸으로 건너는 경우 : 3가지
    // 돌다리가 3개인 경우 : 2개일 경우까지의 경우의 수 + 1칸으로 건너는 경우의 수 : 5가지
    static int solution(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 2;
        arr[2] = 3;
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