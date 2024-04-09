package org.codingTest.dataStruct;

import java.util.*;
import java.util.stream.Collectors;

public class MaxSequence {
    public int solution(int[] nums){
        int answer = 0;

        HashSet<Integer> value = new HashSet<>(); // Set 자료구조는 중복을 제거한다

        for(int n : nums) {
            value.add(n);
        }

        for(int v : value) {
            if(value.contains(v-1)) continue;
            int cnt = 0;
            while (value.contains(v)){
                cnt ++;
                v++;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        MaxSequence T = new MaxSequence();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
