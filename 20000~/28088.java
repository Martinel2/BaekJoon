package solved;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        int[] arr2 = new int[n];
        
        for(int i=0; i<m; i++) {
        	int num = (Integer.parseInt(br.readLine()));
        	arr[num]++;
        }
        
        int ans = m;
        
        for(int i=0; i<k; i++) {
        	int greet = 0;
        	if(i%2==0) {
        		for(int j=0; j<n; j++) {
        			int left = j==0? n-1:j-1;
        			int right = (j+1)%n;
        			
        			arr2[j] = arr[left]^arr[right];
        			if(arr2[j] == 1) greet++;
        		}
        	}else {
        		for(int j=0; j<n; j++) {
        			int left = j==0? n-1:j-1;
        			int right = (j+1)%n;
        			
        			arr[j] = arr2[left]^arr2[right];
        			if(arr[j] == 1) greet++;
        		}
        	}
        	//System.out.println(greet);
        	if(i==k-1) ans = greet;
        }
        
        System.out.println(ans);
    }
}