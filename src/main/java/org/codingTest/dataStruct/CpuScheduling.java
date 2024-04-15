package org.codingTest.dataStruct;

import java.util.*;

public class CpuScheduling {
    public int[] solution(int[][] tasks){

        int max = tasks.length;
        int[] answer = new int[max];
        LinkedList<int[]> programs = new LinkedList<>();

        for(int i=0;i<max;i++) {
            programs.add(new int[]{tasks[i][0], tasks[i][1], i});
        }

        programs.sort(Comparator.comparingInt(a -> a[0])); // (a,b) -> a[0]-b[0]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]==b[0] ? a[1] - b[1] : a[0] - b[0]);
        int fT = 0;
        int idx = 0;

        while(!programs.isEmpty() || !pq.isEmpty()) {
            if(pq.isEmpty())
                fT = Math.max(fT, programs.peek()[0]); // peek : 스택의 가장 위에 있는 항목을 반환한다.
            while(!programs.isEmpty() && programs.peek()[0] <= fT) {
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]});
            }
            int[] ex = pq.poll();
            fT = fT + ex[0];
            answer[idx++] = ex[1];
        }
        return answer;
    }

    public static void main(String[] args){
        CpuScheduling T = new CpuScheduling();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
