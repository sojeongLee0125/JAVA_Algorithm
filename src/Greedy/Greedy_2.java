package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_2 {
    static PriorityQueue<Meeting> pq;

    static class Meeting implements Comparable<Meeting> {
        int st;
        int ed;

        public Meeting(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.ed != o.ed) return this.ed - o.ed;
            else {
                return this.st - o.st;
            }
        }
    }

    static int solution(PriorityQueue<Meeting> pq) {
        int count = 1;
        int end = pq.poll().ed;

        while (!pq.isEmpty()) {
            Meeting m = pq.poll();
            if (m.st >= end) {
                count++;
                end = m.ed;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        pq = new PriorityQueue<>();

        // end 타임을 기준으로 오름차순 정렬 (같을 경우 시작시간 기준)
        // end 타입 이상의 st 추출 및 카운트 & ed time 갱신
        // pq가 빌때까지 실시
        for (int i = 0; i < n; i++) {
            int st = kb.nextInt();
            int ed = kb.nextInt();
            pq.offer(new Meeting(st, ed));
        }

        System.out.println(solution(pq));
    }
}