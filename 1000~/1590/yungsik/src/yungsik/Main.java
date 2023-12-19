package yungsik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(st.nextToken());
		
		long min = Integer.MAX_VALUE;
		boolean go = false;
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			long str = Long.parseLong(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j<cnt; j++) {
				if(t <= str)
					break;
				else
					str += dis;
			}
			
			if(str-t >= 0) {
				go = true;
				if(min > str-t)
					min = str-t;
			}
		}
		
		if(go)
			System.out.println(min);
		else
			System.out.println(-1);
	}
}
