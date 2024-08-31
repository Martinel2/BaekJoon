package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 5*5 1 + 3*4 2 + 2*3 4 + 1*2 + 10 
        // 26 + 14 + 10 + 12 = 62
        
        long ans = 0;
        
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n+1];
        
        for(int i = 1; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i] = Integer.parseInt(st.nextToken());
        	ans += Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i =n; i>=1; i--) ans += arr[i]*i;
        System.out.println(ans);
    }
}