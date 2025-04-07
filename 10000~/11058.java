package solved;

import java.io.*;
import java.util.*;
 
public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        // a-c-v를 하는 것이 a를 출력하는 것보다 이득인 경우 수행
        // 화면에 존재하는 a의 갯수가 3보다 크면 a-c-v수행
        // 버퍼에 복사된 a의 갯수*3 보다 다시 a-c-v를 수행하는게 더 이득인 경우 수행
        
        long[] dp = new long[n+1];
        
        //a만 누르는 경우의 수
        for(int i=1; i<=n; i++) {
        	dp[i] = dp[i-1]+1;
        }
        
        for(int i=3; i<=n; i++) {
        	for(int j=1; j<i; j++)
        		dp[i] = Math.max(dp[i], dp[i-j]*(j-1));
        }
        
        System.out.println(dp[n]);
    }
}