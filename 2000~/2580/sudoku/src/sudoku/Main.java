package sudoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2580 스도쿠
public class Main {
	static int[][] board = new int[9][9];
	
	static void sudoku(int r, int c) {
		
		if(c == 9) {
			sudoku(r+1,0);
			return;
		}
		
		if(r == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(board[r][c] == 0) {
			for(int i = 1; i<=9; i++) {
				if(possible(r,c,i)) {
					board[r][c] = i;
					sudoku(r,c+1);
				}
			}
			board[r][c] = 0; //백트래킹
			return;
		}
		
		sudoku(r,c+1);
	}
	
	static boolean possible(int r, int c, int k) {
		for(int i = 0; i<9; i++) {
			if(board[r][i] == k)
				return false;
			if(board[i][c] == k)
				return false;
		}
		int setr = (r/3)*3;
		int setc = (c/3)*3;
		for(int i = setr; i<setr+3; i++) {
			for(int j = setc; j<setc+3; j++) {
				if(board[i][j] == k)
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0,0);
	}
}
/*
0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0
*/
