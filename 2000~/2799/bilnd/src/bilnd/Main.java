package bilnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] ans = new int[5];
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int[][] bilnd = new int[row][col];
		
		int crow = row*5 + 1;
		int ccol = col*5 + 1;
		
		//for(int i = 1; i<5*col+1; i+=5)
		
		char[][] window = new char[crow][ccol]; //블라인드 그림 배열
		
		for(int i = 0; i<crow; i++) {
			window[i] = br.readLine().toCharArray();
		}
		
		//계산
		for(int i = 0; i<crow; i++) {
			if(window[i][1] == '#')
				continue;
			else{
				for(int j = 1; j<ccol; j+=5) {
					if(window[i][j] == '*') {
						bilnd[i/5][j/5]++;
					}
				}
			}
		}
		
		for(int i = 0; i<row; i++) {
			for(int j = 0; j<col; j++) {
				ans[bilnd[i][j]]++;
			}
		}
		
		for(int val : ans) {
			System.out.print(val+ " ");
		}
	}
}
