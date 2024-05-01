package org.codingTest.dfs;

import java.util.*;

public class Palindrome {

    Deque<Character> tmp;
    ArrayList<String> res;
    HashMap<Character, Integer> sH;

    int len;

    public void DFS() {

        if(tmp.size() == len) {
            String Ts = "";
            for(char x : tmp) Ts += x;
            res.add(Ts);

        }else{

            for(char key : sH.keySet()) {

                if(sH.get(key) == 0 ) continue;

                tmp.addFirst(key);
                tmp.addLast(key);
                sH.put(key, sH.get(key) -2);

                DFS();

                tmp.pollFirst();
                tmp.pollLast();
                sH.put(key, sH.get(key)+2);
            }
        }
    }


    public String[] solution(String s){

        tmp = new LinkedList<>();
        res = new ArrayList<>();
        sH = new HashMap<>();

        len = s.length();

        for(char x : s.toCharArray()) {
            sH.put(x, sH.getOrDefault(x, 0) +1); // 문자 - 문자의 개수
        }

        int odd = 0;
        char mid = '#';

        for(char key : sH.keySet()) {
            if(sH.get(key) % 2 == 1){ // 홀수 이면
                mid = key;
                odd++; // 홀수 개수
            }
        }

        if(odd > 1) return new String[]{}; // 홀수가 2개 이상이면 빈 배열 return

        if (mid != '#') { // 홀수가 있으면...
            tmp.add(mid); //  그 중 마지막 홀수...
            sH.put(mid, sH.get(mid)-1); // 홀수는 하나를 빼...
        }

        DFS();

        String[] answer = new String[res.size()];
        for(int i=0;i<res.size();i++) answer[i] = res.get(i);

        return answer;
    }

    public static void main(String[] args){
        Palindrome T = new Palindrome();
        //System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        //System.out.println(Arrays.toString(T.solution("abbccee")));
        //System.out.println(Arrays.toString(T.solution("abbcceee")));
        //System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }

}
