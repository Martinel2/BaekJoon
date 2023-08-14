import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int v;
			v = Integer.parseInt(st.nextToken());
			max = Math.max(max, v);
			queue.add(v);
		}
		int curmax = max;
		int ans = curmax - queue.peek();
		while(queue.peek() < max) {
			int v = queue.poll();
			ans = Math.min(ans, curmax-v);
			curmax = Math.max(curmax, 2*v);
			queue.add(2*v);
			
		}
		System.out.println(Math.min(curmax-queue.peek(), ans));
	}
}
