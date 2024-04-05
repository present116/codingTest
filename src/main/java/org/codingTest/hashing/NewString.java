package org.codingTest.hashing;

import java.util.*;

public class NewString {
    public int solution(String s){

        /*Map<String, Integer> map = new HashMap<>();

        for(int i=0; i< s.length();i++){

            String str = s.substring(i,i+1);
            int n = map.get(str) != null ? map.get(str) +1  : 1; // map에서 값이 없으면??
            map.put(str, n);
        }

        int min = s.length();
        int cnt = 0;
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                cnt ++;
                min = Math.min(min, s.indexOf(key));

            }
        }

        min = min + 1;

        if(cnt == 0){
            return -1;
        }else{
            return min;
        }*/


        HashMap<Character, Integer> sH = new HashMap<>();
        for(char x : s.toCharArray()){
            sH.put(x, sH.getOrDefault(x, 0) + 1);
            // getOrDefault 반환 값 : 찾는 key가 존재하면 해당 key에 매핑되어 있는 값을 반환하고, 그렇지 않으면 디폴트 값 반환

        }

        for(int i = 0; i < s.length(); i++){
            if(sH.get(s.charAt(i)) == 1) return i+1;
        }

        return -1;

    }

    public static void main(String[] args){
        NewString T = new NewString();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }

}
