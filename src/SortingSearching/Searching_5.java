package SortingSearching;

import java.util.Arrays;
import java.util.Scanner;

public class Searching_5 {
    // 나의 답안
    // 이분 검색으로 범위 1 -> 배열의 값의 합
    // mid 값으로 첫번째부터 담아서 cnt++ 갯수 정산
    // 시간이 남으면 값 갱신 및 작은 범위 탐색, 시간이 모자라면 큰 범위 탐색
    static int solution1(int n, int m, int[] arr) {
        int answer = 0;
        int max = 0;
        for (int i : arr) {
            max += i;
        }
        int lt = 1;
        int rt = max;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int sum = 0;
            int cnt = 1;
            for (int i = 0; i < arr.length; i++) {
                if (sum + arr[i] <= mid) {
                    sum += arr[i];
                } else {
                    cnt++;
                    sum = arr[i];
                }
            }
            if (cnt > m) {
                // 용량을 늘려야 한다.
                lt = mid + 1;
            } else {
                // 답을 갱신하고 용량을 줄여본다.
                answer = mid;
                rt = mid - 1;
            }
        }
        return answer;
    }

    // 강의 답안
    // 결정 알고리즘 : 내가 찾고자하는 답이 범위 사이에 반드시 있을 때 사용
    static int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else sum += x;
        }
        return cnt;
    }

    static int solution2(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution1(n, m, arr));
    }
}