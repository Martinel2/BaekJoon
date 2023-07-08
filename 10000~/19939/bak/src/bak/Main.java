package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//19939
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int init = N-K;
		int ans = 0;
		
		if(init > 0) {
			int sigma = ((K-1)*K)/2;
			if(init >= sigma) {
				init -= sigma;
				if(init%K != 0)
					ans = (K-1) + 1;
				else
					ans = (K-1);
			}
			else
				ans = -1;
		}
		else {
			ans = -1;
		}
		
		System.out.println(ans);
	}
}
