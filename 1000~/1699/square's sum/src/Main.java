import java.io.*;

//1699 Á¦°ö¼öÀÇ ÇÕ
public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int[] squ = new int[N+1];
		dp[0] = 0;
		for(int i = 1; Math.pow(i, 2)<=N; i++) {
			dp[(int)Math.pow(i, 2)] = 1;
			squ[i]=(int)Math.pow(i, 2);
		}
		if(dp[N] != 0)
			System.out.println(1);
		else {
			for(int i = 0; i<N; i++) {
				for(int j = 1; j<N; j++) {
					if(squ[j] == 0)
						break;
					int k = i+squ[j];
					if(k > N)
						break;
					else {
						if(dp[k] == 0 || dp[k] > dp[i] + 1)
							dp[k] = dp[i]+1;
					}
				}
			}
			System.out.println(dp[N]);
		}
	}
}