package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int N;
    static int number = 1; //타일 번호

    static boolean check(int startX, int startY, int size){
        for(int i=startX; i<startX+size; i++){
            for(int j=startY; j<startY+size; j++){
                if(board[i][j]!=0) return false;
            }
        }
        return true;
    }

    static void recursion(int startX, int startY, int size){

        if(size==1){
            return;
        }

        int newSize = size/2;
        if(check(startX, startY, newSize)){
            board[startX+newSize-1][startY+newSize-1] = number;
        }
        if(check(startX, startY+newSize, newSize)){
            board[startX+newSize-1][startY+newSize] = number;
        }
        if(check(startX+newSize, startY, newSize)){
            board[startX+newSize][startY+newSize-1] = number;
        }
        if(check(startX+newSize, startY+newSize, newSize)){
            board[startX+newSize][startY+newSize] = number;
        }
        number++;

//        showBoard();
        System.out.println();

        recursion(startX, startY, newSize);
        recursion(startX, startY+newSize, newSize);
        recursion(startX+newSize, startY, newSize);
        recursion(startX+newSize, startY+newSize, newSize);

    }

    static void showBoard(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine());
        N = (int) Math.pow(2, n);
        board = new int[N][N];

        stk = new StringTokenizer(br.readLine());
        int holeX = Integer.parseInt(stk.nextToken());
        int holeY = Integer.parseInt(stk.nextToken());
        board[N-holeY][holeX-1] = -1;

        recursion(0, 0, N);

        showBoard();
    }
}