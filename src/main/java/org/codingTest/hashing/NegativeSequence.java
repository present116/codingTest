package org.codingTest.hashing;
import java.util.*;

public class NegativeSequence {
    public int solution(int[] nums, int m){
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for(int n : nums) {
            sum += n;
            if(map.containsKey(sum-m)) answer += map.get(sum-m);
            map.put(sum, map.getOrDefault(sum ,0)+1);
        }
        return answer;
    }

    public static void main(String[] args){
        NegativeSequence T = new NegativeSequence();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
