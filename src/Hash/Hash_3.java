package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hash_3 {
    static ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // 슬라이딩 윈도우 값 세팅
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.add(map.size());

        // 슬라이딩 윈도우 밀고가기
        for (int i = k; i < n; i++) {
            map.put(arr[i - k], map.get(arr[i - k]) - 1);
            // 0되면 키 삭제
            if (map.get(arr[i - k]) == 0) map.remove(arr[i - k]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            answer.add(map.size());
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (Integer integer : solution(n, k, arr)) {
            System.out.print(integer + " ");
        }
    }
}