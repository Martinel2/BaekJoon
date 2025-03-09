package solved;

import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n,m;
        
        st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        
        long[] time = new long[n];
        for(int i = 0; i < n; i++) {
            time[i] = Long.parseLong(br.readLine());
        }
        
        long maxTime = (long) Math.pow(10, 9) * (long) Math.pow(10,9);
        long ans = maxTime;
        
        long left = 0;
        long right = maxTime;
        while(left<=right) {
        	long mid = (left+right)/2;
        	long sum = 0;
        	for(int i=0; i<n; i++) {
        		sum += mid/time[i];
        		if(sum > m) break;
        	}
        	
        	if(sum < m) left = mid+1;
        	else {
        		ans = Math.min(ans,mid);
        		right = mid-1;
        	}
        }
        System.out.println(ans);
    }
}