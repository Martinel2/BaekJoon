package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());

		boolean pos = true;
		
		Queue<String>[] q = new LinkedList[n];
		HashSet<String> dup = new HashSet<>();
		for(int i =0; i<n; i++) {
			q[i] = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int len = st.countTokens();
			for(int j=0; j<len; j++) {
				String w = st.nextToken();
				if(dup.contains(w)) {
					pos = false;
				}
				dup.add(w);
				q[i].add(w);
				
			}
		}
		st = new StringTokenizer(br.readLine());
		if(pos)
			while(st.hasMoreTokens()) {
				String word = st.nextToken();
				pos = false;
				for(int i = 0; i<n; i++) {
					if(word.equals(q[i].peek())) {
						q[i].poll();
						pos = true;
						break;
					}
				}
				if(!pos) break;
			}
		for(int i = 0; i<n; i++) {
			if(!q[i].isEmpty()) {
				pos = false;
				break;
			}
		}
		String ans = pos? "Possible":"Impossible";
		System.out.println(ans);
	}
}
