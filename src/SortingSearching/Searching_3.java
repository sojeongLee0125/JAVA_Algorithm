package SortingSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Searching_3 {
    // 나의 답안
    // arr 원본과 arr을 오름차순으로 정렬한 2개의 배열을 만든다.
    // 2개의 배열을 비교하면서 서로 다른부분을 기록한다.
    // 해당 index를 리턴
    public static int[] solution1(int n, int[] arr) {
        int[] answer = new int[2];
        int[] copy = arr.clone();
        Arrays.sort(arr);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != copy[i]) answer[idx++] = i + 1;
        }

        return answer;
    }

    // 강의 답안
    public static ArrayList<Integer> solution2(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) answer.add(i + 1);
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
        for (int x : solution2(n, arr)) {
            System.out.print(x + " ");
        }
    }
}