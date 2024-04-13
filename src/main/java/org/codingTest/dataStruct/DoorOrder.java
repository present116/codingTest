package org.codingTest.dataStruct;

import java.util.*;
public class DoorOrder {

    public int[] solution(int[] arrival, int[] state){ // 인덱스별 들어오는 초, 상태
        final int IN = 0;
        final int OUT = 1;

        int max = arrival.length;
        int prev = 1;
        int cnt = 0;

        int[] answer = new int[max];

        Queue<Integer> in = new LinkedList<>(); // 들어오는 사원의 index 저장
        Queue<Integer> out = new LinkedList<>(); // 나가는 사원의 index 저장

        for(int time=0, i=0;;time++) {

            if(in.isEmpty() && out.isEmpty() && i < max){
                if(time < arrival[i]) {
                    time = arrival[i];
                    prev = OUT;
                }

            }

            while (i<max && arrival[i] <= time) {
                if (state[i] == OUT) {
                    out.offer(i);
                } else {
                    in.offer(i);
                }
                i++;
            }

            if (prev == OUT) {
                if (!out.isEmpty()) {
                    answer[out.poll()] = time;
                    prev = OUT;
                } else {
                    answer[in.poll()] = time;
                    prev = IN;
                }

            } else if(prev == IN) {
                if (!in.isEmpty()) {
                    answer[in.poll()] = time;
                    prev = IN;
                } else {
                    answer[out.poll()] = time;
                    prev = OUT;
                }
            }
            cnt++;
            if(cnt == max) break;
        }

        return answer;
    }

    public static void main(String[] args){
        DoorOrder T = new DoorOrder();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
