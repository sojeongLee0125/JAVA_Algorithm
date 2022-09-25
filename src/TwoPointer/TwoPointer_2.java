package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoPointer_2 {

    static ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // 포인터로 비교후 작은 쪽의 포인터를 증가 같으면 답에 넣고 둘다 포인터 증가
        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) p1++;
            else if (arr2[p2] < arr1[p1]) p2++;
            else {
                // 둘이 같은 경우
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }
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