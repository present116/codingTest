package org.codingTest.graph;
import java.util.*;

public class TransferMin {
    public int solution(int[][] routes, int s, int e){

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;

        for(int i=0;i<n;i++) { // i -> 호선
            for(int x : routes[i]) { // i호선의 내용물...
                graph.putIfAbsent(x, new HashSet<Integer>());
                graph.get(x).add(i); // 내용물 검사해서 호선을 넣어준다...
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        int[] ch = new int[n]; // 총 호선 개수

        Q.offer(s); // s -> 출발역 번호
        int L = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i=0;i<len;i++) {
                int curStop = Q.poll();
                for(int line : graph.get(curStop)) { // 특정 번호에서 호선을 찾는다...
                    if(ch[line] == 1) continue;
                    ch[line] = 1;
                    for(int stop : routes[line]) {
                        if(stop == e) return L; // 도착역
                        Q.offer(stop);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        TransferMin T = new TransferMin();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
