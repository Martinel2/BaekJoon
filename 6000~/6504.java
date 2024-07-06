package solved;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] fibo = new int[21];
		fibo[0] = 1;
		fibo[1] = 2;
		for(int i = 2; i<21; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			int ans = 0;
			int num = Integer.parseInt(br.readLine());
			for(int j = 20; j>=0; j--) {
				if(num >= fibo[j]) {
					num -= fibo[j];
					if(j>0) ans += fibo[j-1];
					//System.out.println(ans+" "+num);
					if(num == 0) break;
				}
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
		
	}
}