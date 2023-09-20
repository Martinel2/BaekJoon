import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int per = 2*N;
		st = new StringTokenizer(br.readLine());
		
		int[] ab = new int[per];
		
		for(int i = 0; i<per; i++) {
			ab[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ab);
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			int team = ab[i] + ab[per-i-1];
			
			if(ans > team)
				ans = team;
		}
		
		System.out.println(ans);
	}
}
