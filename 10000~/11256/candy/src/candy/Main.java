package candy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int candy = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int max = 0;
			int[] box = new int[n];
			
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				box[i] = r*c;
			}
			
			Arrays.sort(box);
			
			int ans = 0;
			for(int i = n-1; i>=0; i--) {
				 candy -= box[i];
				 ans++;
				 if(candy <= 0)
					 break;
			}
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
}
