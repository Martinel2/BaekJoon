package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		//1 2 3 4 5  6  7  8
		//1 2 3 4 5  6  7  8  9
		//2 4 6 8 10 12 14 16 ...
		//0 2 0 2 4  6  0
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			long n = Long.parseLong(br.readLine());
			long left = 1;
			long right = 1000000000;
			long exp = (n*(n+1))/2;
			
			while(left<=right) {
				long mid = (left+right)/2;
				long need = (mid*(mid+1));
				
				if(need > exp) right = mid-1;
				else left = mid+1;
				
			}
			sb.append(left).append('\n');	
		}
		System.out.println(sb);
	}
}