package String;

import java.util.ArrayList;
import java.util.Scanner;

public class String_4 {

    static ArrayList<String> solution1(int n, String[] s) {
        ArrayList<String> answer = new ArrayList<>();
        for (String str : s) {
            str = new StringBuilder(str).reverse().toString();
            answer.add(str);
        }
        return answer;
    }

    static ArrayList<String> solution2(int n, String[] s) {
        ArrayList<String> answer = new ArrayList<>();
        for (String str : s) {
            char[] c = str.toCharArray();
            int lt = 0;
            int rt = str.length() - 1;
            while (lt < rt) {
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(c);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = kb.next();
        }
        for (String x : solution2(n, s)) {
            System.out.println(x);
        }
    }
}
