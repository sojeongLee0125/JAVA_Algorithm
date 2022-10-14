package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Greedy_1 {
    static ArrayList<Person> p = new ArrayList<>();
    static class Person implements Comparable<Person> {
        int h;
        int w;

        public Person(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Person o) {
            return o.h - this.h;
        }
    }

    static int solution() {
        int count = 1;
        int max = p.get(0).w;

        for (int i = 1; i < p.size(); i++) {
            if (p.get(i).w > max) {
                count++;
                max = p.get(i).w;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        // 각 사람을 입력받아서 키를 기준으로 내림차순 정렬한다.
        // 첫번째 사람은 무조건 count 첫번째 사람의 몸무게를 기준 값으로 잡는다.
        // 두번째 사람의 몸무게가 몸무게 기준값보다 크면 count, 몸무게 기준값을 갱신한다.
        int n = kb.nextInt();
        for (int i = 0; i < n; i++) {
            int h = kb.nextInt();
            int w = kb.nextInt();
            p.add(new Person(h, w));
        }

        Collections.sort(p);
        System.out.println(solution());
    }
}