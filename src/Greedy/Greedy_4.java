package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_4 {
    static ArrayList<Lecture> lectures = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static int max = Integer.MIN_VALUE;

    static class Lecture implements Comparable<Lecture> {
        int money;
        int date;

        public Lecture(int money, int date) {
            this.money = money;
            this.date = date;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.date - this.date;
        }
    }

    static int solution() {
        // MAX 일자 부터 시작
        // MAX 일자 해당되는 Lecture 의 money 전부 pq 내림차순 삽입
        // 1개 poll answer 갱신
        // max 하루 뺀 날에 해당되는 Lecture money 전부 삽입 -> 반복

        int answer = 0;
        Collections.sort(lectures);

        // max가 다음값으로 넘어갔을 때 j값은 이어져야 하므로 밖으로 뺀다.
        int j = 0;

        for (int i = max; i > 0; i--) {
            for (; j < lectures.size(); j++) {
                if (lectures.get(j).date < i) break;
                else pq.offer(lectures.get(j).money);
            }
            // 현재 날짜 강의 순회 완료
            // 현재 pq 중에서 가장 큰 값을 정답에 갱신
            if (!pq.isEmpty()) answer += pq.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for (int i = 0; i < n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            lectures.add(new Lecture(m, d));
            if (d > max) max = d;
        }

        System.out.println(solution());
    }
}