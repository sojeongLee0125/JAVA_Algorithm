package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Stack_3 {

    // 나의 답안
    static int solution1(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        // moves 배열을 순회하면서 board의 위치를 파악한다.
        // 해당 board를 순회하며 0이 아닌 제일 위의 숫자를 꺼낸다.
        // 해당 숫자는 0으로 만든다.
        // 해당 숫자를 유효성 검사하고 아닐 경우 stack에 담는다.

        for (int x : moves) {
            for (int i = 0; i < n; i++) {
                if (board[i][x - 1] != 0) {
                    // stack 의 최상위를 꺼내서 같으면 cnt++ pop()
                    if (stack.size() > 1) {
                        if (stack.peek() == board[i][x - 1]) {
                            board[i][x - 1] = 0;
                            answer += 2;
                            stack.pop();
                            break;
                        }
                    }
                    // stack에 1개 이하로 존재하거나 같지 않으면 push
                    stack.push(board[i][x - 1]);
                    board[i][x - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    // 강의 답안
    static int solution2(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int x : moves) {
            for (int i = 0; i < n; i++) {
                if (board[i][x - 1] != 0) {
                    int tmp = board[i][x - 1];
                    board[i][x - 1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }

        System.out.println(solution2(n, board, m, moves));
    }
}