package solved;

import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] arr;
	static boolean[] sub = new boolean[20*1000000+1];
	static void bruthforce(int idx, int sum) {
		if(idx == n) {
			sub[sum] = true;
			return;
		}
		
		bruthforce(idx+1, sum+arr[idx]);
		bruthforce(idx+1, sum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
	
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bruthforce(0,0);
		
		for(int i = 1; i<sub.length; i++) {
			if(!sub[i]) {
				System.out.println(i);
				break;
			}
		}
   }
}