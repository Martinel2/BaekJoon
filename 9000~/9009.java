package solved;

import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		int[] fibo = new int[45];
		int idx=2;
		fibo[0] = 0;
		fibo[1] = 1;
		while(fibo[idx-1]+fibo[idx-2] <= 1000000000) {
			fibo[idx] = fibo[idx-1] + fibo[idx-2];
			idx++;
		}
		
		while(t-->0) {
			int num = Integer.parseInt(br.readLine());
			int idx2 = 44;
			int[] f = new int[45];
			for(int i = 44; i>=0; i--) {
				if(num >= fibo[i]) {
					f[idx2--] = fibo[i];
					num -= fibo[i];
					//System.out.println(fibo[i] + " " + num);
				}
				if(num <= 0) break;
			}
			for(int i = idx2+1; i<45; i++) {
				sb.append(f[i]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
