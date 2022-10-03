package SortingSearching;

import java.util.Arrays;
import java.util.Scanner;

public class Searching_2 {

    public static String solution(int n, int[] arr) {
        String answer = "U";
        // 정렬을 한다.
        Arrays.sort(arr);
        // 이웃된 숫자 탐색
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) return "D";
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution(n, arr));
    }
}