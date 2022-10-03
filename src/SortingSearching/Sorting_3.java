package SortingSearching;

import java.util.Scanner;

public class Sorting_3 {
    public static int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = 0;
            // i의 앞쪽으로 돌면서 현재 tmp 보다 큰 값들은 다 뒤로 밀기.
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) arr[j + 1] = arr[j];
                else break;
            }
            // j가 앞으로 가다가 멈춘 지점에 앞에 tmp 삽입
            arr[j + 1] = tmp;
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