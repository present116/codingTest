package org.codingTest;

import java.util.*;

class Sadari {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        // * ----------------------
        // * 시뮬레이션 - 1. 사다리 타기
        // * ----------------------


        for(int i=0;i<n;i++){
            answer[i] = (char) (65 + i);
        }

        for(int i=0;i<ladder.length;i++){
            for(int l : ladder[i]) {
                char temp = answer[l];
                answer[l] = answer[l-1];
                answer[l-1] = temp;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Sadari T = new Sadari();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7,9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}