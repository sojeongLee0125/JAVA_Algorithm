package String;

import java.util.Scanner;

public class String_3 {

    static String solution1(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        String[] s = str.split(" ");

        for (String s1 : s) {
            int len = s1.length();
            if (len > max) {
                max = len;
                answer = s1;
            }
        }

        return answer;
    }

    static String solution2(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int pos = 0;

        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > max) {
                max = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }

        // 마지막 단어 처리
        if (str.length() > max) {
            answer = str;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution2(str));
    }
}
