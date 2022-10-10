package DFS;

import java.util.Scanner;
import java.util.Stack;

public class DFS_1 {
    static int[] arr;
    static int num, sum;
    static Stack<Integer> stack = new Stack<>();

    // 나의 정답
    // 요소를 집합에 포함하는 경우 / 포함하지 않는 경우
    static String dfs(int cnt) {
        // base case
        if (cnt >= num) {
            // 전체 합 - 부분집합에 포함된 합 = 부분집합의 합이면 return "YES"
            int tmp = stack.stream().mapToInt(i -> i).sum();
            if (sum - tmp == tmp) return "YES";
            else return "";
        }

        stack.push(arr[cnt]);
        if (dfs(cnt + 1).equals("YES")) return "YES";

        stack.pop();
        if (dfs(cnt + 1).equals("YES")) return "YES";

        return "NO";
    }

    // 강의 답안 - Flag 사용
    static boolean flag = false;
    static String classAnswer = "NO";

    static void dfs2(int cnt, int localSum) {
        // yes 답을 구한 경우 재귀 정지
        if (flag) return;
        // 부분집합의 합이 전체 합의 반을 넘는 경우 재귀 정지
        if (localSum > sum / 2) return;

        // base case
        if (cnt == num) {
            if ((sum - localSum) == localSum) {
                classAnswer = "YES";
                flag = true;
            }
        } else {
            // arr[cnt] 를 사용하는 경우
            dfs2(cnt + 1, localSum + arr[cnt]);
            // arr[cnt] 를 사용하지 않는 경우
            dfs2(cnt + 1, localSum);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        num = kb.nextInt();
        arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = kb.nextInt();
            sum += arr[i];
        }

        // 나의 답안
        System.out.println(dfs(0));

        // 강의 답안
        dfs2(0, 0);
        System.out.println(classAnswer);
    }
}