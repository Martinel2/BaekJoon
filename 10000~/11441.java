package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	arr[i] += arr[i-1];
        }
        
        //arr[k] - arr[k-m] = arr[n] + arr[n-1] + ... + arr[n-(m-1)];
        
        int m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int str = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	int sum = arr[end] - arr[str-1];
        	sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
