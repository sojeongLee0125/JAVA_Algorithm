package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class Hash_4 {
    static int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();

        // t 문자열 hashmap 세팅
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        // 슬라이딩 윈도우 세팅
        for (int i = 0; i < t.length(); i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
            if (tmap.equals(smap)) answer++;
        }

        // 밀고 나가면서 비교
        for (int i = t.length(); i < s.length(); i++) {
            char ex = s.charAt(i - t.length());
            smap.put(ex, smap.get(ex) - 1);
            if (smap.get(ex) == 0) smap.remove(ex);
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
            if (tmap.equals(smap)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        String t = kb.nextLine();
        System.out.println(solution(s, t));
    }
}