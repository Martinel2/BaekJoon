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
		
		int[] arr = new int[dp[1]+1]; // dp[1]이 최소값. N도 저장해야하므로 +1
		
		//1부터 역으로 탐색해서 순서 구하기
		int idx = 1; // 1부터 시작
		int cnt = dp[1]; // 내림차순으로 저장하기 위해 끝에서부터 시작
		
		while(idx <= N) {
			arr[cnt--] = idx;
			
			if(idx * 3 <= N && dp[idx]-1 == dp[idx*3]) // 3으로 곱하기
				idx *= 3;
			else if(idx * 2 <= N && dp[idx]-1 == dp[idx*2]) //2로 곱하기
				idx *= 2;	 
			else if(idx + 1 <= N && dp[idx]-1 == dp[idx+1]) //1 더하기
				idx += 1;
			else
				break;
			
		}
		
		// 출력 //
		System.out.println(dp[1]);
		for(int i = 0; i<=dp[1]; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}
