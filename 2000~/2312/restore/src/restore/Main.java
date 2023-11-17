package restore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
				
				
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			
			for(int div = 2;  div<=n; div++) {
				int cnt = 0;
				while(n > 0) {
					if(n % div == 0) {
						n /= div;
						cnt++;
					}
					else
						break;
				}
				if(cnt!=0)
					sb.append(div).append(" ").append(cnt).append('\n');
				if(n <= 1)
					break;
			}
		}
		System.out.println(sb);
	}
}
