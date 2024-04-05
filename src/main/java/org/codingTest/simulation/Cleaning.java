package org.codingTest.simulation;

import java.util.*;

public class Cleaning {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        // 윗쪽, 오른쪽, 아랫쪽, 왼쪽

        int count = 0;
        int value = 1;


        int max = board.length;

        while(k > count) {
            count++;

            int x = answer[0] + dx[value];
            int y = answer[1] + dy[value];

            if(x < 0 || x >= max || y < 0 || y >= max || board[x][y] == 1){
                value = (value + 1) %4 ;
                continue;
            }

            answer[0] = x;
            answer[1] = y;

        }
        return answer;
    }

    public static void main(String[] args){
        Cleaning T = new Cleaning();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
