import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			long num = Long.parseLong(st.nextToken());
			pq.add(num);
		}
		
		
		for(int i = 0; i<m; i++) {
			long a = pq.poll();
			long b = pq.poll();
			
			a = a+b;
			b = a;
			pq.add(a);
			pq.add(b);
		}
		
		long ans = 0;
		for(long num : pq) {
			ans += num;
		}
		System.out.println(ans);
	}
}
