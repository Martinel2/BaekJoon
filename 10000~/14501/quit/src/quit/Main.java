package quit;
import java.io.*;
import java.util.*;


//14501 퇴사
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N][2];
		int[] dp = new int[N+1];
		int max = 0;
		for(int i = 0; i<N; i++)
		{
			st= new StringTokenizer(br.readLine(), " ");
			schedule[i][0] = Integer.parseInt(st.nextToken());//소요일수
			schedule[i][1] = Integer.parseInt(st.nextToken());//금액
		}
		for(int i = 0; i<N; i++)
		{
			for(int j = i; j<N; j++)
			{
				int sum = dp[i];
				int cnt = j;
				int k = j;
				while(cnt+schedule[k][0] <= N)
				{
					cnt+=schedule[k][0];
					sum += schedule[k][1];
					if(dp[cnt] < sum)
						dp[cnt]=sum;
					if(max<dp[cnt])
						max = dp[cnt];
					k += schedule[k][0];
					if(k >= N)
						break;
				}
			}
		}
		System.out.print(max);
	}
}