package stock;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] day = new int[N];
			int max = 0;
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<N; i++) {
				day[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = N-1; i>=0; i--) {
				if(day[i] > max)
					max = day[i];
				else
					ans += (max-day[i]);
			}
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
/*
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2
*/
