package org.codingTest.greedy;

import java.util.*;

public class SinkBoat {
    public int solution(int[] nums, int m){
        int answer = 0;
        int sum = 0;
        // 1보트에 2명이 탈 수 있고, 그 보트의 최고 무게는 m
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length -1;

        while(left <= right) {
            if(nums[left] + nums[right] <= m){
                answer++;
                left++;
                right--;
            }else{
                answer++;
                right--;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        SinkBoat T = new SinkBoat();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
