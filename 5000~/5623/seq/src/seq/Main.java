package seq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		int[] ans = new int[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(N == 2) {
			ans[0] = ans[1] = arr[0][1]/2;
		}
		else {
			ans[0] = ((arr[0][1]+arr[0][2]) - arr[1][2])/2; //(2a + b + c) - (b+c)
			for(int i = 1; i<N; i++) {
				ans[i] = arr[i][0] - ans[0];
			}
		}
		
		for(int v : ans) {
			System.out.print(v + " ");
		}
	}
}
