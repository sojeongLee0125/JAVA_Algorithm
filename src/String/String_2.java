package String;

import java.util.Scanner;

public class String_2 {

    static String solution1(String str) {
        String answer = "";

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }
        }

        return answer;
    }

    static String solution2(String str) {
        String answer = "";

        for (char c : str.toCharArray()) {
            if (c >= 97 && c <= 122) {
                answer += (char) (c - 32);
            } else {
                answer += (char) (c + 32);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution2(str));
    }
}
