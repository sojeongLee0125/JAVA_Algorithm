package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Array_3 {
    static ArrayList<String> solution(int num, int[] aList, int[] bList) {
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            if ((aList[i] == 1 && bList[i] == 3) || (aList[i] == 2 && bList[i] == 1) || (aList[i] == 3 && bList[i] == 2)) {
                answer.add("A");
            } else if (aList[i] == bList[i]) {
                answer.add("D");
            } else {
                answer.add("B");
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int[] aList = new int[num];
        for (int i = 0; i < num; i++) {
            aList[i] = kb.nextInt();
        }
        int[] bList = new int[num];
        for (int i = 0; i < num; i++) {
            bList[i] = kb.nextInt();
        }
        for (String s : solution(num, aList, bList)) {
            System.out.println(s);
        }
    }
}
