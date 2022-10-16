package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Greedy_3 {
    static ArrayList<Time> timeList = new ArrayList<>();

    static class Time implements Comparable<Time> {
        int time;
        int state; // s = 2 / e = 1

        public Time(int time, int state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time != o.time) {
                return this.time - o.time;
            } else {
                return this.state - o.state;
            }
        }
    }

    static int solution() {
        int answer = 0;
        int count = 0;

        for (int i = 0; i < timeList.size(); i++) {
            Time t = timeList.get(i);
            if (t.state == 2) {
                count++;
                answer = Math.max(answer, count);
            } else {
                count--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        // 클래스 - 시간 + 상태값
        // 시간의 오름차순으로 리스트에 저장
        // 하나씩 꺼내면서 (같은 시간일 경우) e를 먼저 꺼낸다.
        // s일 경우 cnt++ / answer 갱신
        // e일 경우 cnt--

        for (int i = 0; i < n; i++) {
            int s = kb.nextInt();
            int e = kb.nextInt();
            timeList.add(new Time(s, 2));
            timeList.add(new Time(e, 1));
        }

        Collections.sort(timeList);

        System.out.println(solution());
    }
}