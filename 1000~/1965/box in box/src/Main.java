import java.io.*;
import java.util.*;

//1965 상자넣기
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		int max = 1;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = i+1; j<N; j++) {
				if(arr[i] < arr[j] && dp[j] < dp[i]+1)
					dp[j] = dp[i] + 1;
				if(max < dp[j])
					max = dp[j];
			}
		}
		System.out.println(max);
	}
}
