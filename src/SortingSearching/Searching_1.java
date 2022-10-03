package SortingSearching;

import java.util.Scanner;

public class Searching_1 {

    // 나의 답안
    // arr을 순차적으로 돈다.
    // 1) 기존에 존재하는 값일 경우 : 배열을 돌면서 해당 값을 찾고, 해당 값 앞의 값들을 한 칸씩 뒤로 밀고, 해당 값을 0번에 넣는다.
    // 2) 기존에 존재하지 않을 경우 : 해당 값을 0번에 넣고, 모든 값을 한 칸씩 뒤로 민다.
    public static int[] solution1(int s, int n, int[] arr) {
        int[] answer = new int[s];
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            boolean sw = false;

            // 기존에 값이 존재할 경우
            for (int j = 0; j < s; j++) {
                if (answer[j] == cur) {
                    for (int k = j - 1; k >= 0; k--) {
                        answer[k + 1] = answer[k];
                    }
                    answer[0] = cur;
                    sw = true;
                    break;
                }
            }

            // 기존에 값이 존재하지 않을 경우
            if (!sw) {
                for (int k = s - 1; k > 0; k--) {
                    answer[k] = answer[k - 1];
                }
                answer[0] = cur;
            }
        }

        return answer;
    }

    // 강의 답안
    public static int[] solution2(int s, int n, int[] arr) {
        int[] answer = new int[s];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < s; i++) if (x == answer[i]) pos = i;
            if (pos == -1) {
                // 캐시 미스의 상황
                for (int i = s - 1; i >= 1; i--) {
                    answer[i] = answer[i - 1];
                }
            } else {
                // 캐시 히트의 상황
                for (int i = pos; i >= 1; i--) {
                    answer[i] = answer[i - 1];
                }
            }
            answer[0] = x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : solution2(s, n, arr)) {
            System.out.print(x + " ");
        }
    }
}