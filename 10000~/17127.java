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
       
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	arr[i] *= arr[i-1];
        }
        
        int a1 = arr[n-4] + (arr[n-3]/arr[n-4]) + (arr[n-2]/arr[n-3]) + (arr[n-1]/arr[n-2]);
        int a2 = arr[0] + (arr[n-3]/arr[0]) + (arr[n-2]/arr[n-3]) + (arr[n-1]/arr[n-2]);
        int a3 = arr[0] + (arr[1]/arr[0]) + (arr[n-2]/arr[1]) + (arr[n-1]/arr[n-2]);
        int a4 = arr[0] + (arr[1]/arr[0]) + (arr[2]/arr[1]) + (arr[n-1]/arr[2]);
        
        int ans = Math.max(a1, Math.max(a2, Math.max(a3, a4)));
        
        System.out.println(ans);
    }
}
