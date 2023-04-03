package budmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visit = new boolean[10];
	static int[] arr = new int[11];
	static char[] d;
	static int k;
	static boolean f = false;
	static String min = "";
	static String max = "000";
	static void backtracking(int cur, int idx) {
		if(idx == k) {
			if(!f) {
				f = true;
				for(int i = 0; i<=idx; i++) {
					min += arr[i];
				}
			}
			else {
				String temp = "";
				for(int i = 0; i<=idx; i++) {
					temp += arr[i];
				}
				if(Long.valueOf(max) < Long.valueOf(temp))
					max = temp;
			}
		}
		else {
			for(int i = 0; i<10; i++) {
				if(!visit[i]) {
					if(d[idx] == '<' && cur < i) {
						arr[idx+1] = i;
						visit[i] = true;
						backtracking(i,idx+1);
						visit[i] = false;
					}
					else if(d[idx] == '>' && cur > i) {
						arr[idx+1] = i;
						visit[i] = true;
						backtracking(i,idx+1);
						visit[i] = false;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		d = new char[k];
		for(int i = 0; i<k; i++) {
			d[i] = st.nextToken().charAt(0);
		}
		
		for(int i = 0; i<10; i++) {
			arr[0] = i;
			visit[i] = true;
			backtracking(i,0);
			visit[i] = false;
		}
		System.out.print(max + "\n" + min);
	}
}
