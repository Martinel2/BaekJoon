package filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[row][col];
		
		for(int i = 0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<col; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
			
		}
		
		int T = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for(int i = 0; i<=row-3; i++) {
			for(int j = 0; j<=col-3; j++) {
				//ÇÊÅÍ ¾º¿ì±â
				int[] filter = new int[9];
				int idx = 0;
				for(int n = i; n<i+3; n++) {
					for(int m = j; m<j+3; m++) {
						filter[idx++] = arr[n][m];
					}
				}
				Arrays.sort(filter);
				
				//System.out.println(filter[4]);
				if(T <= filter[4])
					ans++;
			}
		}
		
		System.out.println(ans);
	}
}


/*
6 5
49 36 73 62 21
27 88 14 11 12
99 18 36 91 21
45 96 72 12 10
12 48 49 75 56
12 15 48 86 78
40
 */
