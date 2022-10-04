package SortingSearching;

import java.util.*;

public class Searching_4 {
    static int solution(int m, int[] arr) {
        int lt = 0;
        int rt = arr.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) return mid + 1;
            if (arr[mid] > m) rt = mid - 1;
            else lt = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(solution(m, arr));
    }
}