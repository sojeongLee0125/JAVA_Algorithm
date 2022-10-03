package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_2 {
    // 나의 답안
    // queue에 필수과목을 넣는다.
    // q에서 하나를 뺀다.
    // 수업 설계서를 돌면서 q에서 뺀 과목을 만나면 pop
    // 수업 설계서를 순회한 뒤에 q에 남아있는 과목이 있으면 no
    public static String solution1(String es, String plan) {
        Queue<Character> q = new LinkedList<>();

        for (char x : es.toCharArray()) {
            q.offer(x);
        }

        for (char x : plan.toCharArray()) {
            if (!q.isEmpty()) {
                char tmp = q.peek();
                if (x == tmp) {
                    q.poll();
                }
            } else {
                return "YES";
            }
        }
        return "NO";
    }

    // 강의 답안
    public static String solution2(String es, String plan) {
        Queue<Character> q = new LinkedList<>();

        for (char x : es.toCharArray()) {
            q.offer(x);
        }

        for (char x : plan.toCharArray()) {
            if (q.contains(x)) {
                if (x != q.poll()) return "NO";
            }
        }

        if (!q.isEmpty()) return "NO";

        return "YES";
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String es = kb.next();
        String plan = kb.next();
        System.out.println(solution2(es, plan));
    }
}