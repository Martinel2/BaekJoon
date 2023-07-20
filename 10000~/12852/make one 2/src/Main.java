import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		for(int i = N; i>1; i--) {
			int cnt = dp[i];
			
			//3으로 나누어떨어지면 3으로 나눈다
			if(i % 3 == 0) {
				int idx = i/3;
				if(dp[idx] == 0)
					dp[idx] = cnt+1;
				else
					dp[idx] = Math.min(cnt+1, dp[idx]);
			}
			
			//2로 나누어떨어지면 2로 나눈다
			if(i % 2 == 0) {
				int idx = i/2;
				if(dp[idx] == 0)
					dp[idx] = cnt+1;
				else
					dp[idx] = Math.min(cnt+1, dp[idx]);
			}
			
			//1을 뺀다
			if(dp[i-1] == 0)
				dp[i-1] = cnt+1;
			else
				dp[i-1] = Math.min(dp[i-1], cnt+1);
		}
		
		int[] arr = new int[dp[1]+1];
		int idx = 1;
		int cnt = 0;
		while(idx <= N) {
			arr[cnt++] = idx;
			
			if(idx * 3 <= N && dp[idx]-1 == dp[idx*3])
				idx *= 3;
			else if(idx * 2 <= N && dp[idx]-1 == dp[idx*2])
				idx *= 2;	
			else if(idx + 1 <= N && dp[idx]-1 == dp[idx+1])
				idx += 1;
			else
				break;
			
		}
		
		
		System.out.println(dp[1]);
		for(int i = dp[1]; i>=0; i--) {
			System.out.print(arr[i]+ " ");
		}
	}
}
