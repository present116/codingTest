package org.codingTest.simulation;

class LoseDog {
    public int solution(int[][] board){
        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        // 윗쪽, 오른쪽, 아래쪽, 왼쪽
        int max = 10000;
        int[] location = new int[2];
        int[] dog = new int[2];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 2) {
                    location[0] = i;
                    location[1] = j;
                }
                if(board[i][j] == 3) {
                    dog[0] = i;
                    dog[1] = j;
                }
            }
        }

        int cnt = 0;
        int lct = 0;
        int dlct = 0;

        while(max > cnt) {
            cnt ++;
            int x = location[0] + dx[lct];
            int y = location[1] + dy[lct];

            int xx = dog[0] + dx[dlct];
            int yy = dog[1] + dy[dlct];

            boolean pflag = true;
            boolean dflag = true;
            if(x < 0 || x >=10 || y < 0 || y >= 10 || board[x][y] == 1) {
                lct = (lct +1) % 4;
                pflag = false;
            }
            if(xx < 0 || xx >=10 || yy < 0 || yy >= 10 || board[xx][yy] == 1) {
                dlct = (dlct +1) % 4;
                dflag = false;
            }

            if(pflag) {
                location[0] = x;
                location[1] = y;
            }

            if(dflag) {
                dog[0] = xx;
                dog[1] = yy;
            }

            if(location[0] == dog[0]  && location[1] == dog[1]) {
                break;
            }
        }

        if(cnt >= 10000) {
            answer = 0;
        }else{
            answer = cnt;
        }

        return answer;
    }

    public static void main(String[] args){
        LoseDog T = new LoseDog();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}