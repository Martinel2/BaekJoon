package solved;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = n-1;
        int ans = 0;
        while(left < right) {
        	//System.out.println(arr[left] + " "+ arr[right]);
        	if(arr[left] + arr[right] <= s) {
        		left++;
        		if(left >= right) {
            		ans += left;
            		right--;
            		left = 0;
        		}
        	}
        	else {
        		ans += left;
        		right--;
        		left = 0;
        	}
        }
        
        System.out.println(ans);
    }
}