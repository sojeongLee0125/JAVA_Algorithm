package String;

import java.util.Scanner;

public class String_7 {

    static String solution1(String str) {
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();

        // 길이의 절반까지만 진행하면 된다.
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return "NO";
            }
        }

        return answer;
    }

    static String solution2(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp)) {
            return "YES";
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution2(str));
    }
}
