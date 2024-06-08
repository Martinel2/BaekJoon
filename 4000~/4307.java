package solved;

import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int max = 0;
			int min = 0;
			int mid = n/2;
			for(int i = 0; i<l; i++) {
				int num = Integer.parseInt(br.readLine());
				if(num > mid) {
					max = Math.max(max, num);
					min = Math.max(min, n-num);
				}
				else {
					max = Math.max(max, n-num);
					min = Math.max(min, num);
				}
			}
			sb.append(min).append(' ').append(max).append('\n');
		}
		System.out.println(sb);
	}
}
