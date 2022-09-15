package String;

import java.util.Scanner;

public class String_9 {

    static int solution1(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        return Integer.parseInt(answer);
    }

    static int solution2(String str) {
        int answer = 0;
        for (char c : str.toCharArray()) {
            if (c >= 48 && c <= 57) {
                answer = (answer * 10) + (c - '0');
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution1(str));
        System.out.println(solution2(str));
    }
}
