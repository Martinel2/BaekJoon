package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    
	    int t = Integer.parseInt(st.nextToken());
	    
	    long mod = 1000000007;
	    
	    while(t-->0) {
	    	int n  = Integer.parseInt(br.readLine());
	    	
	    	PriorityQueue<Long> pq = new PriorityQueue<>();
	    	
	    	st =new StringTokenizer(br.readLine());
	    	for(int i = 0; i<n; i++) {
	    		pq.add(Long.parseLong(st.nextToken()));
	    	}
	    	
	    	if(n==1) {
	    		sb.append("1\n");
	    		continue;
	    	}
	    	
	    	long ans = 1;
	    	while(pq.size() != 1) {
	    		long a = pq.poll()%mod;
	    		long b = pq.poll()%mod;
	    		long mul = (a*b);
	    		ans *= mul%mod;
	    		ans %= mod;
	    		pq.add(mul);
	    	}
	    	sb.append(ans).append('\n');
	    }
	    System.out.println(sb);
	}
}