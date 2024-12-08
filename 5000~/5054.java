package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int t = Integer.parseInt(st.nextToken());
    	
    	while(t-->0) {
    		int n = Integer.parseInt(br.readLine());
    		int[] arr = new int[n];
    		int ans = 0;
    		
    		st = new StringTokenizer(br.readLine());
    		int max = 0;
    		int min = 100;
    		for(int i=0; i<n; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    			max = Math.max(max, arr[i]);
    			min = Math.min(min, arr[i]);
    		}
    		ans = (max-min)*2;
    		sb.append(ans).append('\n');
    	}
    	System.out.println(sb);
    	
    }
}
