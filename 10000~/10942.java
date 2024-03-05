package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	//입력받는 수자체를 문자로 본다. - 자릿수에 따라 생겨나는 펠린드롬은 없음
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		st =new StringTokenizer(br.readLine());
		
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = 1; //자기자신은 펠린드롬이다.
		}
		
		for(int i=1; i<n; i++){
            if(arr[i] == arr[i+1]) //자신의 앞숫자와 같으면
                dp[i][i+1] = 1;//두 수를 합치면 펠린드롬이다.
        }
		
		for(int k=2; k<n; k++){
            for(int i=1; i<n; i++){
            	//두 끝점이 같고, 두 끝점의 사이에 있는 수들은 펠린드롬이 성립할 때
                if(i+1 <= n && i+k <= n && dp[i+1][i+k-1] == 1 && arr[i] == arr[i+k])
                    dp[i][i+k] = 1; // 해당 수도 펠린드롬이다.
            }
        }
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(dp[s][e]).append('\n');
		}
		
		System.out.println(sb);
    }
}
