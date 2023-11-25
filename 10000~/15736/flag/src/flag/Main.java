package flag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 1;
		
		int exp = 2;
		while(Math.pow(ans,exp) <= N) {
			ans++;
		}
		
		System.out.println(ans-1);
	}
}
