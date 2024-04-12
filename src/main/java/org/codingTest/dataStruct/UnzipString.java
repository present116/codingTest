package org.codingTest.dataStruct;

import java.util.Stack;

public class UnzipString {

    public String solution(String s){
        String answer = "";
        Stack<String> st = new Stack<>();

        for(char x : s.toCharArray()) {
            if(x == ')') {
                String tmp = "";
                while(!st.empty()) {
                    String c = st.pop(); // 빼버리면 아예 빠짐
                    if(c.equals("(")) {
                        String num = "";
                        while(!st.empty() && Character.isDigit(st.peek().charAt(0))) { // 스택 맨위값이 숫자면 ex) 2, 3
                            // isDigit() -> char 인지 아닌지 확인 함수, true or false
                            // peek() -> 스택의 가장 위에 있는 항목을 반환한다.
                            // charAt() -> String 타입의 데이터(문자열)에서 특정 문자를 char 타입으로 변환할 때 사용하는 함수
                            num = st.pop() + num; // ex) 2, 3
                        }
                        String res = "";
                        int cnt = 0;
                        if(num.equals(""))
                            cnt = 1;
                        else
                            cnt = Integer.parseInt(num);
                        for(int i=0;i<cnt;i++)
                            res += tmp;
                        st.push(res);
                        break;
                    }
                    tmp = c + tmp;
                }
            } else {
                st.push(String.valueOf(x));
            }
        }

        for(String x : st)
            answer += x;
        return answer;
    }

    public static void main(String[] args){
        UnzipString T = new UnzipString();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
