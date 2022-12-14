import java.io.*;
import java.util.*;

//11060 점프 점프
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		if(N == 1)
			System.out.println(0);
		else {
			for(int i = 0; i<N; i++) {
				int m = arr[i];
				if(i !=0 && dp[i] == 0)
					continue;
				for(int j = 1; j<=m; j++) {
					if(i+j <N && (dp[i+j] == 0 || dp[i+j] > dp[i]+1) )
						dp[i+j] = dp[i]+1;
				}
			}
			if(dp[N-1] == 0)
				System.out.print("-1");
			else
				System.out.print(dp[N-1]);
		}
	}
}
