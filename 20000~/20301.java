package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main {
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Deque<Integer> de = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			de.add(i);
		}
		
		int cnt = 0;
		boolean dir = true;
		while(!de.isEmpty()) {
			if(dir) {
				for(int i=1; i<k; i++) {
					de.addLast(de.pollFirst());
				}
				sb.append(de.pollFirst()).append('\n');
				cnt++;
			}
			else {
				for(int i=1; i<k; i++) {
					de.addFirst(de.pollLast());
				}
				sb.append(de.pollLast()).append('\n');
				cnt++;
			}
			if(cnt == m) {
				cnt=0;
				dir = !dir;
			}
		}
		
		System.out.println(sb);
	}
}