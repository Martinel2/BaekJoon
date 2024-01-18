import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		int max = 0;
		
		for(int i = 0; i<N; i++) {
			for(int j = i-1; j>=0; j--) {
				if(arr[i] > arr[j] && dp[i] < dp[j])
					dp[i] = dp[j];
			}
			dp[i]++;
			if(max < dp[i])
				max = dp[i];
		}
		
		System.out.println(max);
	}
}
