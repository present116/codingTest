package org.codingTest.hashing;
import java.util.*;
public class PresidentialElection {
    public String solution(String[] votes, int k){
        String answer = "";
        HashMap<String, HashSet<String>> cc = new HashMap<>(); // 추천한 학생 - 추천받은 학생들
        HashMap<String, Integer> can = new HashMap<>(); // 추천받은 학생들 - 받은 횟수
        HashMap<String, Integer> result = new HashMap<>(); // 추천한 학생 - k이상 추천받은 학생의 받은 횟수

        for(String v : votes) {
            String a = v.split(" ")[0];
            String b = v.split(" ")[1];

            // putIfAbsent : Key 값이 존재하는 경우 Map의 Value의 값을 반환하고, Key값이 존재하지 않는 경우 Key와 Value를 Map에 저장하고 Null을 반환합니다.
            cc.putIfAbsent(a, new HashSet<String>());
            cc.get(a).add(b);
            can.put(b, can.getOrDefault(b, 0) +1);
        }

        int max = Integer.MIN_VALUE;
        for(String c : cc.keySet()) { // 추천한 학생
            int cnt = 0;
            for(String cv : cc.get(c)) { // 추천 받은 학생
                if(can.get(cv) >= k ){ // 여기서 추천받은 학생이 k가 넘으면 cnt++ 한다
                    cnt++;
                }
            }
            result.put(c, cnt);
            max = Math.max(max, cnt);
        }

        ArrayList<String> tmp = new ArrayList<String>();
        for(String r : result.keySet()) {
            if(result.get(r) == max) {
                tmp.add(r);
            }
        }

        tmp.sort(String::compareTo); // tmp.sort((a,b) -> a.compareTo(b))
        answer = tmp.get(0);
        return answer;
    }

    public static void main(String[] args){
        PresidentialElection T = new PresidentialElection();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
