package org.codingTest.simulation;

import java.util.*;
public class SeatNumber {

    public int[] solution(int c, int r, int k){
        int[] answer = {0, 0};
        if(k > c * r)
            return new int[] {0, 0};

        int[][] seat = new int[c][r];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int lct = 0;
        int cnt = 1;

        while(k > cnt) {
            int x = answer[0] + dx[lct];
            int y = answer[1] + dy[lct];

            if(x < 0 || x >= c || y < 0 || y >= r || seat[x][y] > 0) {
                lct = (lct + 1) % 4;
                continue;
            }


            seat[answer[0]][answer[1]] = cnt;
            cnt++;
            answer[0] = x;
            answer[1] = y;

        }

        answer[0] = answer[0] + 1;
        answer[1] = answer[1] + 1;
        return answer;
    }

    public static void main(String[] args){
        SeatNumber T = new SeatNumber();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
