package solved;

import java.util.*;
import java.io.*;

public class Main {

	static class M{
		int x;
		int y;
		
		M(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int n;
	static char[][] board;
	static ArrayList<M> t = new ArrayList<>();
	
	static boolean bt(int cnt, int x, int y) {
		
		if(cnt == 0) {
			for(M m : t) {
				//상
				for(int i=m.x-1; i>=0; i--) {
					if(board[i][m.y] == 'O') break;
					if(board[i][m.y] == 'S') return false;
				}
				//하
				for(int i=m.x+1; i<n; i++) {
					if(board[i][m.y] == 'O') break;
					if(board[i][m.y] == 'S') return false;
				}
				//좌
				for(int i=m.y-1; i>=0; i--) { 
					if(board[m.x][i] == 'O') break;
					if(board[m.x][i] == 'S') return false;
				}
				//우
				for(int i=m.y+1; i<n; i++) { 
					if(board[m.x][i] == 'O') break;
					if(board[m.x][i] == 'S') return false;
				}
			}
			return true;
		}
		
		for(int i=x; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == x && j < y) continue;
				if(board[i][j] == 'X') {
					board[i][j] = 'O';
					if(bt(cnt-1,i,j)) return true;
					board[i][j] = 'X';
				}
			}
		}
		
		return false;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        board = new char[n][n];
        
        for(int i =0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		board[i][j] = st.nextToken().charAt(0);
        		if(board[i][j] == 'T') t.add(new M(i,j));
        	}
        }
        
        System.out.println(bt(3,0,0)? "YES":"NO");
    }
}