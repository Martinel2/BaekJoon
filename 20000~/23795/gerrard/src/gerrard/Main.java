package gerrard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		int cnt = Integer.parseInt(br.readLine());
		while(cnt != -1) {
			ans += cnt;
			cnt = Integer.parseInt(br.readLine());
		}
		
		System.out.println(ans);
	}
}
