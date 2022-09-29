package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class Hash_2 {
    static String solution(String str1, String str2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : str2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) return "NO";
            // 이미 상단에 다 셋팅되었으므로 KEY가 없을 수가 없음.
            map.put(x, map.get(x) - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        String str2 = kb.next();
        System.out.println(solution(str1, str2));
    }
}