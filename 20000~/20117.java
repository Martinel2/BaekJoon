package solved;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        
        int n = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int ans = 0;
        int left = 0;
        int right = n-1;
        while(left < right) {
        	ans += arr[right]*2;
        	left++;
        	right--;
        }
        if(left == right) {
        	ans += arr[left];
        }
        //(n/2)+1
        //(n+1)/2
        System.out.println(ans);
    }
}