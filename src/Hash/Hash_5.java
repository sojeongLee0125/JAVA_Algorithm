package Hash;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Hash_5 {
    static int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int l = j + 1; l < arr.length; l++) {
                    int sum = arr[i] + arr[j] + arr[l];
                    tset.add(sum);
                }
            }
        }

        int cnt = 0;
        for (int x : tset) {
            cnt++;
            if (cnt == k) answer = x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution(n, k, arr));
    }
}