import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//9507
	static long koong(int n) {
		if(n < 2) return 1;
		else if(n == 2) return 2;
		else if(n == 3) return 4;
		else if(dp[n] != 0) return dp[n];
		else {
			dp[n] = koong(n-1) + koong(n-2) + koong(n-3) + koong(n-4);
			return dp[n];
		}
	}
	static long[] dp = new long[68];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(koong(n)).append("\n");
		}
		
		System.out.println(sb);
	}
}
