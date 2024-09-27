package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	long k = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[n];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	int left = 0;
    	int right = n-1;
    	
    	int ans=0;
    	while(left<right) {
    		long two = arr[left]+arr[right];
    		if(two <= k) {
    			ans++;
    			left++;
    			right--;
    		}
    		else right--;
    	}
    	System.out.println(ans);
    }
}