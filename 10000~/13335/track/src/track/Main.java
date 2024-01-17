package track;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		int weight = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> road = new LinkedList<>();
		
		st=  new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i<len; i++) {
			road.add(0);
		}
		
		int ans = 0;
		int track = 0;
		while(true) {
			ans++;
			track -= road.poll();
			if(!q.isEmpty()) {
				if(q.peek() + track <= weight) {
					track += q.peek();
					road.add(q.poll());
				}
				else
					road.add(0);
			}
			if(road.isEmpty())
				break;
		}
		
		System.out.println(ans);
	}
}
