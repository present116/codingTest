package org.codingTest.bfs;

import java.util.*;

public class HoldCow {

    public int solution(int s, int e){

        int[][] ch = new int[2][200001]; // 0 - 짝수초 & 1 - 홀수초
        Queue<Integer> Q = new LinkedList<>();

        ch[0][s] = 1;
        Q.offer(s);
        int L = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();
            L++;

            for(int i=0;i<len;i++) {
                int x = Q.poll();
                for(int nx : new int[]{x-1, x+1, x*2}) { // nx 는 자식 레벨들
                    if(nx >=0 && nx<=200000 && ch[L%2][nx] == 0) {
                        ch[L%2][nx] = 1;
                        Q.offer(nx);
                    }
                }
            }

            e = e + L;
            if(e>2000000) return -1;
            if(ch[L%2][e] == 1) return L;

        }
        return -1;
    }

    public static void main(String[] args){
        HoldCow T = new HoldCow();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }


}
