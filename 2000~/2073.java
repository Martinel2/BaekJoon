package solved;

import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        int[][]arr =new int [m][2];
 
        for(int i=0; i<m; i++){
        	st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
 
        int [] dp = new int[n+1];
 
        dp[0] = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            for(int j=n; j>=arr[i][0]; j--){
                dp[j] = Math.max(dp[j],Math.min(dp[j-arr[i][0]],arr[i][1]));
            }
        }
        System.out.println(dp[n]);
    }
}