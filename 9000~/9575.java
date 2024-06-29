package solved;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int lenA = Integer.parseInt(br.readLine());
			int[] a = new int[lenA];
			st=new StringTokenizer(br.readLine());
			for(int i =0; i<lenA; i++)
				a[i] = Integer.parseInt(st.nextToken());

			int lenB = Integer.parseInt(br.readLine());
			int[] b = new int[lenB];
			st=new StringTokenizer(br.readLine());
			for(int i =0; i<lenB; i++)
				b[i] = Integer.parseInt(st.nextToken());

			int lenC = Integer.parseInt(br.readLine());
			int[] c = new int[lenC];
			st=new StringTokenizer(br.readLine());
			for(int i =0; i<lenC; i++)
				c[i] = Integer.parseInt(st.nextToken());
			HashSet<Integer> hs = new HashSet<>();
			for(int i = 0; i<lenA; i++) {
				for(int j = 0; j<lenB; j++) {
					for(int k = 0; k<lenC; k++) {
						int sum = a[i] + b[j] + c[k];
						boolean luck = true;
						int ss = sum;
						while(sum !=0) {
							if(sum%10 != 5 && sum%10 != 8) {
								//System.out.println(sum);
								luck = false;
								break;
							}
							sum/=10;
						}
						if(luck) hs.add(ss);
					}
				}
			}
			
			sb.append(hs.size()).append('\n');
		}
		
		System.out.println(sb);
	}
}