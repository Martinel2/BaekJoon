package solved;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
                
        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        //6 1 5 2 4 3 = 6 0 4 0 2 0 = 12
        //5 1 4 2 3 = 5 0 3 0 1 = 9
        int[] arr = new int[n];
        
        for(int i = 0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        int left = -1;
        int right = n-1;
        int ans = 0;
        while(left<right) {
        	if(right == n-1) {
        		ans += arr[right];
        	}
        	else {
        		ans += arr[right]-arr[left];
        	}
        	
        	left++;
        	right--;
        }
        System.out.println(ans);
    }
}