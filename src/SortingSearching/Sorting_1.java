package SortingSearching;

import java.util.Scanner;

public class Sorting_1 {
    public static int[] solution(int n, int[] arr) {
        // 선택정렬
        // i번째 선택
        // j = i+1 부터 전체까지 돌면서 현재 i보다 작은 수 변경
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[idx]) idx = j;
                // arr[i] 와 arr[idx] swap
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int i : solution(n, arr)) {
            System.out.print(i + " ");
        }

    }
}