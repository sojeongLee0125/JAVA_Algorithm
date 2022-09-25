package TwoPointer;

import java.util.Scanner;

public class TwoPointer_1 {

    static int[] solution(int n, int m, int[] arr1, int[] arr2) {
        int[] answer = new int[n + m];
        // p1, p2 포인터를 돌면서 작은 숫자면 결과리스트에 추가하고 포인터++
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                answer[i++] = arr1[p1++];
            } else {
                answer[i++] = arr2[p2++];
            }
        }

        while (p1 < n) {
            answer[i++] = arr1[p1++];
        }

        while (p2 < m) {
            answer[i++] = arr2[p2++];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = kb.nextInt();
        }

        for (int i : solution(n, m, arr1, arr2)) {
            System.out.print(i + " ");
        }

    }
}