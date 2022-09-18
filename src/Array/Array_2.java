package Array;

import java.util.Scanner;

public class Array_2 {
    static int solution(int num, int[] numList) {
        int answer = 1;
        int max = numList[0];

        for (int i = 1; i < num; i++) {
            if (numList[i] > max) {
                answer++;
                max = numList[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int[] numList = new int[num];
        for (int i = 0; i < num; i++) {
            numList[i] = kb.nextInt();
        }
        System.out.println(solution(num, numList));
    }
}
