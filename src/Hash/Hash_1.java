package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class Hash_1 {
    static String solution(int n, String str) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        for (Character c : map.keySet()) {
            int tmp = map.get(c);
            if (tmp > max) {
                answer = c + "";
                max = tmp;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(solution(n, str));
    }
}