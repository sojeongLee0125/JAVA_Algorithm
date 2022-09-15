package String;

import java.util.Scanner;

public class String_8 {

    static String solution1(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equals(tmp)) {
            return "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution1(str));
    }
}
