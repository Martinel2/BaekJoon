package suom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int weight = 0;
		int ans = 0;
		
		if(N > 0) {
			st= new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(weight+num <= M) {
					weight += num;
				}
				else {
					ans++;
					weight = num;
				}
			}
			ans+=1;
		}
		System.out.println(ans);
	}
}
