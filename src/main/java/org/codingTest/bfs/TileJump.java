package org.codingTest.bfs;

import java.util.*;
public class TileJump {
    public int solution(int[] nums){
        int n = nums.length;
        int[] ch = new int[n]; // 방문 했는지 안했는지 확인용

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0); // 값 추가

        ch[0] = 1;
        int L = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0;i<len;i++) { // Q.size()
                int x = Q.poll();

                for(int j=1;j<=nums[x];j++) { // nums 각 숫자
                    int nx = x + j;
                    if(nx == n-1) return L+1;
                    if(nx < n && ch[nx]==0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        TileJump T = new TileJump();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
