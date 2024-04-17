package org.codingTest.sorting;

import java.util.*;

public class BinaryNumber {

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        int[][] res = new int[nums.length][2];

        for(int i=0;i<nums.length;i++) {
            int result = nums[i];
            int cnt = 0;

            while(result > 0) { // result /2  == 0
                /*if(result % 2 == 1){
                    cnt++;
                }*/

                cnt += (result%2);
                result = result/2;
            }
            res[i][0] = nums[i];
            res[i][1] = cnt;
        }

        Arrays.sort(res, (a,b)-> a[1] == b[1] ? a[0] -b[0] : a[1]-b[1]);

        for(int i=0;i<res.length;i++) {
            answer[i] = res[i][0];
        }

        return answer;
    }

    public static void main(String[] args){
        BinaryNumber T = new BinaryNumber();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
