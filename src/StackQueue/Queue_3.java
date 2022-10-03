package StackQueue;

import java.util.*;

public class Queue_3 {

    public static class Person {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    // 나의 답안
    // list 값들을 priorityQueue와 일반 q에 넣는다.
    // priority 에서 1개를 꺼낸다.
    // 일반 q의 값과 pq의 값이 일치하면 치료하는것 -> 꺼내고 순번++ && 구하고자 하는 답의 q 값이면 현재 순번 값 리턴
    public static int solution1(int n, int m, int[] list) {
        Queue<Person> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            q.add(new Person(i, list[i]));
            pq.offer(list[i]);
        }

        int answer = 0;
        while (!q.isEmpty()) {
            Person p = q.poll();
            if (pq.peek() == p.priority) {
                pq.poll();
                answer++;
                if (p.id == m) return answer;
            } else {
                q.offer(p);
            }
        }

        return answer;
    }

    // 강의 답안
    public static int solution2(int n, int m, int[] list) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(new Person(i, list[i]));
        }

        while (!q.isEmpty()) {
            Person p = q.poll();
            // 현재 환자보다 더 응급도가 높은 환자 순회
            for (Person x : q) {
                if (x.priority > p.priority) {
                    q.offer(p);
                    p = null;
                    break;
                }
            }
            if (p != null) {
                answer++;
                if (p.id == m) return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = kb.nextInt();
        }
        System.out.println(solution2(n, m, list));
    }
}