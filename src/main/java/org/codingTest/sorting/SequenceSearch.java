package org.codingTest.sorting;

import java.util.*;
public class SequenceSearch {

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        HashMap<Integer, Integer> nH = new HashMap<>();

        for(int n : nums) {
            nH.put(n, nH.getOrDefault(n, 0)+1);
        }

        Arrays.sort(nums);

        int cnt = 0;
        for(int n : nums) {

            if(nH.get(n) == 0) continue;
            answer[cnt] = n;
            cnt++;

            nH.put(n, nH.get(n)-1);
            nH.put(n*2, nH.get(n*2)-1);
        }

        return answer;
    }

    public static void main(String[] args){
        SequenceSearch T = new SequenceSearch();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }

}
