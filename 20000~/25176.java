package solved;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        int sum = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	sum += arr[i];
        	max = Math.max(max, arr[i]);
        }
        
        System.out.println(sum - max);
        
        
    }
}