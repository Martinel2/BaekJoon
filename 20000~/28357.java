package solved;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        
        long[] arr = new long[n];
        long min = 0;
        long max = 1000000000000l;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        }
        
        while(min <= max) {
        	//System.out.println(min + " " + max);
        	long mid = (min+max)/2;
        	long sum = 0;
        	for(int i = 0; i<n; i++) {
        		if(arr[i] > mid)
        			sum += arr[i] - mid;
        		if(sum > k) break;
        	}
        	if(sum > k) {
    			min = mid+1;
    		}
        	else {
        		max = mid-1;
        	}
        }
        System.out.println(max+1);
        
    }
}