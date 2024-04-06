package org.codingTest.hashing;

import java.util.*;

public class SameFrequency {
    public int[] solution(String s){

        int[] answer = new int[5]; // a, b, c, d, e
        /*HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('a', 0); // 65
        map.put('b', 0); // 66
        map.put('c', 0); // 67
        map.put('d', 0); // 68
        map.put('e', 0); // 69

        int max = 0;
        for(char c : s.toCharArray()) {
            Integer cnt = map.get(c);
            cnt = cnt + 1;
            map.put(c, cnt);
            max = Math.max(cnt, max);
        }

        for(int i=0; i<5;i++){
            answer[i] = map.containsKey((char)(97 + i)) ? max-map.get((char)(97 + i)) : 3;
        }*/

        HashMap<Character, Integer> sH = new HashMap<>();
        for(char x : s.toCharArray()){
            sH.put(x, sH.getOrDefault(x, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        String tmp = "abcde";
        for(char key : tmp.toCharArray()){
            if(sH.getOrDefault(key, 0) > max){
                max = sH.getOrDefault(key, 0);
            }
        }
        for(int i = 0; i < tmp.length(); i++){
            answer[i] = max - sH.getOrDefault(tmp.charAt(i), 0);
        }
        return answer;
    }

    public static void main(String[] args){
        SameFrequency T = new SameFrequency();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
