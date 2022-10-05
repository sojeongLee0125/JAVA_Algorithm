package SortingSearching;

import java.util.Arrays;
import java.util.Scanner;

public class Searching_6 {
    // 나의 답안
    static int solution1(int n, int c, int[] arr) {
        int answer = 0;
        // 입력값 정렬
        Arrays.sort(arr);
        // 범위 1 ~ max
        int lt = 1;
        int rt = arr[arr.length - 1];
        // 이분탐색 시작 - 첫번째 값부터 해당 거리만큼 더해서 배치
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int pos = arr[0];
            int cnt = 1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - pos >= mid) {
                    // 배치 가능한 좌표
                    cnt++;
                    pos = arr[i];
                }
            }
            // 반목문을 다 돌고나면 전체 좌표에 배치 완료
            if (cnt >= c) {
                // 배치가 가능한 경우 정답값 갱신 및 최대거리를 증가
                answer = mid;
                lt = mid + 1;
            } else {
                // 현재 배치가 불가능한 경우 최대거리를 감소
                rt = mid - 1;
            }
        }
        return answer;
    }

    // 강의 답안
    static int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }

    static int solution2(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[arr.length - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution2(n, c, arr));
    }
}