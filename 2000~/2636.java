package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cheese, ans, time;
    static int[][] board;
    static boolean[][] isVisited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        cheese = 0;
        time = 0; 
        ans = 0;

        board = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(board[i][j] == 1)
                    cheese++;
            }
        }

        while(cheese != 0){
            time++;
            ans = cheese;
            meltCheese();
        }

        System.out.println(time);
        System.out.println(ans);
    }

    private static void meltCheese() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        isVisited = new boolean[N][M];

        isVisited[0][0] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || N <= nx || M <= ny || isVisited[nx][ny])  continue;

                if(board[nx][ny] == 1){
                    cheese--;
                    board[nx][ny] = 0;
                }
                else if(board[nx][ny] == 0){
                    queue.offer(new int[]{nx,ny});
                }

                isVisited[nx][ny] = true;
            }
        }
    }
}