package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class P implements Comparable<P>{
		int p;
		int s;
		long total;
		
		P(int p , int s){
			this.p = p;
			this.s = s;
			this.total = p+s;
		}
		
		@Override
		public int compareTo(P o) {
			if(this.total == o.total)
				return this.p - o.p;
			return (int)(this.total - o.total);
		}
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	
    	P[] arr = new P[n];
    	for(int i = 0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int p = Integer.parseInt(st.nextToken());
    		int s = Integer.parseInt(st.nextToken());
    		
    		arr[i] =  new P(p,s);
    	}
    	
    	Arrays.sort(arr);
    	int ans = 0;
    	for(int i = n-1; i>=0; i--) {
    		long sum = arr[i].p/2 + arr[i].s;
    		int cnt = 1;
    		
    		if(sum > b) continue;
    		
    		for(int j = 0; j<n; j++) {
    			if(j==i) continue;
    			if(sum + arr[j].total <= b) {
	    			sum += arr[j].total;
	    			cnt++;
    			}
    			else break;
    		}
    		ans = Math.max(ans, cnt);
    	}
    	System.out.println(ans);
    }
}
