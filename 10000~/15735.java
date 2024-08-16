package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		
		long[] sum = new long[10005];
		sum[1]=1;
		for(int i =2; i<=10000; i++) {
			sum[i] += sum[i-1] + i; // 1, 1+2, 1+2+3, ....
		}
		int n = Integer.parseInt(br.readLine());
		
		long ans = 0;
		
		for(int i = 1; i<=n; i++) ans += sum[i]; //똑바로선 정삼각형
		for(int i = n-1; i>0; i-=2) ans += sum[i]; //역방향 정삼각형
		
		System.out.println(ans);
   }
}