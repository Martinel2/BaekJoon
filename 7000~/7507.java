package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class M implements Comparable<M>{
		int day;
		int str;
		int end;
		
		M(int day, int str, int end){
			this.day=day;
			this.str = str;
			this.end=end;
		}
		
		@Override
		public int compareTo(M o) {
			if(this.day == o.day) {
				if(this.end == o.end) return this.str-o.str;
				return this.end-o.end;
			}
			return this.day - o.day;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
		
			M[] o = new M[n];
			for(int i =0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int day = Integer.parseInt(st.nextToken());
				int str = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				o[i] = new M(day,str,end);
			}
			
			Arrays.sort(o);
			int ans = 1;
			int idx = 0;
			for(int i = 1; i<n; i++) {
				if(o[idx].day == o[i].day && o[idx].end <= o[i].str) {
					ans++;
					idx = i;
				} else if(o[idx].day != o[i].day) {
					ans++;
					idx = i;
				}
			}
			
			sb.append("Scenario #").append(t).append(":\n").append(ans).append('\n').append('\n');
		}
		
		System.out.println(sb);
	}
}