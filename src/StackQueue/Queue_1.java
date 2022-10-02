package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_1 {
    // 나의 답안
    // queue에 전부 삽입
    // 하나씩 빼서 다시 큐에 넣는데 k번째는 그냥 뺀다.
    // 큐의 사이즈가 1개일때까지 반복한다.
    public static int solution1(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            for (int i = 1; i < k; i++) {
                int tmp = q.poll();
                q.offer(tmp);
            }
            q.poll();
        }

        return q.poll();
    }

    // 강의 답안
    public static int solution2(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) q.offer(i);

        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) q.offer(q.poll());
            q.poll();
            if (q.size() == 1) answer = q.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.println(solution2(n, k));
    }
}