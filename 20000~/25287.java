package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0) {
        	int n = Integer.parseInt(br.readLine());
        	int[] arr = new int[n];
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i<n; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	// 1-n, 2-(n-1), 3-(n-2)...
        	int bef = Math.min(arr[0], n-arr[0]+1);
        	boolean make = true;
        	for(int i = 1; i<n; i++) {
        		int max = Math.max(arr[i], n-arr[i]+1);
        		int min = Math.min(arr[i], n-arr[i]+1);
        		if(bef <= min) bef = min;
        		else if(bef <= max) bef = max;
        		else {
        			make = false;
        			break;
        		}
        	}
        	String ans = make? "YES\n":"NO\n";
        	sb.append(ans);
        }
        System.out.println(sb);
    }
}