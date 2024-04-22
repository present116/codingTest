package org.codingTest.greedy;

import java.util.*;
public class MoveCount {
    public int solution(int[] nums){
        int answer = 0;
        // n개의 물건, 5kg이하로 왕복이 한번이라고 할때, 최소 이동횟수로 n개 물건을 옮김
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            if(nums[left] + nums[right] <= 5) {
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
        MoveCount T = new MoveCount();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
