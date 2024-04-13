package org.codingTest.dataStruct;

import java.util.*;

public class LaserEnter {

    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H*60+M;
    }

    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int max = enter.length;
        int[][] inList = new int[max][2];
        for(int i=0;i<max;i++) {
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split( " ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }

        Queue<Integer> Q = new LinkedList<Integer>();
        Q.offer(inList[0][1]); // 종류 저장 ex) 0 / offer : 넣기
        int fT = inList[0][0]; // 분 저장 ex) 623
        int pos = 1; // 다음 값

        for(int t = fT; t<=1200; t++) { // 623 ~ 1200
            if(pos < max && t == inList[pos][0]) { // 대기 인지 아닌지...
                if(Q.isEmpty() && t > fT) { // 그런데 큐가 비어있거나, 타임이 목표치보다 크면
                    fT = t;
                }
                Q.offer(inList[pos][1]); // 대기가 맞으면 Q에 넣기
                pos++;
            }

            if(t == fT && !Q.isEmpty()) { // 해당것인지...
                int idx = Q.poll(); // poll : 빼내기
                fT += laser[idx];
            }

            answer = Math.max(answer, Q.size());
        }

        return answer;
    }

    public static void main(String[] args){
        LaserEnter T = new LaserEnter();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }


}
