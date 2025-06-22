package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	static class Team implements Comparable<Team>{
		int idx;
		int cnt;
		int score;
		int log;
		int[] problem;
		
		Team(int idx, int score, int cnt, int log, int pn){
			this.idx = idx;
			this.cnt = cnt;
			this.score = score;
			this.log = log;
			this.problem = new int[pn];
		}
		
		public void getPoint(int pn, int s, int log) {
			this.log = log;
			cnt++;
			int max = Math.max(problem[pn], s);
			score += max - problem[pn];
			problem[pn] = max;
		}
		
		@Override
		public int compareTo(Team o) {
			if(this.score == o.score) {
				if(this.cnt==o.cnt) return this.log-o.log;
				return this.cnt - o.cnt;
			}
			return o.score - this.score;
		}
	}
	
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		StringBuilder sb = new StringBuilder();
		int t = fr.nextInt();
		
		while(t-->0) {
			int n = fr.nextInt();
			int k = fr.nextInt();
			int id = fr.nextInt()-1;
			int m = fr.nextInt();

			Team[] arr = new Team[n];
			for(int i=0; i<n; i++) {
				arr[i] = new Team(i,0,0,0,k);
			}
			for(int i=0; i<m; i++) {
				int idx = fr.nextInt()-1;
				int pn = fr.nextInt()-1;
				int score = fr.nextInt();
				
				arr[idx].getPoint(pn, score,i);
			}
			Arrays.sort(arr);
			for(int i=0; i<n; i++) {
				if(arr[i].idx == id) {
					sb.append(i+1).append('\n');
					break;
				}
			}
		}
		System.out.println(sb);
	}
}