package org.codingTest.simulation;

import java.util.ArrayList;

public class BitonicSequence {

    public int solution(int[] nums){
        int answer = 0;
        ArrayList<Integer> peak = new ArrayList<>();

        for(int i=1; i< nums.length-1;i++) {
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                peak.add(i);
            }
        }

        for(int p : peak) {
            int left = p;
            int right = p;
            int cnt = 1;

            while(left-1 >= 0 && nums[left-1] < nums[left]) {
                left--;
                cnt++;
            }

            while(right+1 < nums.length && nums[right+1] < nums[right]) {
                right++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        BitonicSequence T = new BitonicSequence();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
