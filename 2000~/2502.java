package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		
		//f(2) = f(1) + f(0)
		int D,K;
		D= Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[31];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<=30; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		int A=1;
		int B;
		while(true) {
			if((K-dp[D-3]*A)%dp[D-2]==0) {
				B=(K-dp[D-3]*A)/dp[D-2];
				break;
			}
			A++;
		}
		System.out.println(A);
		System.out.println(B);
	}
}