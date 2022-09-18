package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Array_1 {
    static ArrayList<Integer> solution(int num, int[] numList) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(numList[0]);
        for (int i = 1; i < num; i++) {
            if (numList[i] > numList[i - 1]) {
                answer.add(numList[i]);
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
        for (int i : solution(num, numList)) {
            System.out.print(i + " ");
        }
    }
}
