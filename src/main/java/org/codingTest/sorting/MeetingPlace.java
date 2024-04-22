package org.codingTest.sorting;

import java.util.*;

public class MeetingPlace {
    public int solution(int[][] board){
        int answer=0;

        int max = board.length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();

        for(int i=0;i<max;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        col.sort((a,b)->a-b); // 오름차수 정렬
        int x = row.get(row.size() / 2);
        int y = col.get(col.size() / 2);
        for(int p : row) answer += Math.abs(x-p);
        for(int p : col) answer += Math.abs(y-p);

        return answer;
    }

    public static void main(String[] args){
        MeetingPlace T = new MeetingPlace();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
