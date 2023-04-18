import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long ans = 0;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[N];
		long[] cnt = new long[M];
		st = new StringTokenizer(br.readLine());
		sum[0] = Integer.parseInt(st.nextToken())%M;
		cnt[sum[0]]++;
		
		for(int i = 1; i<N; i++) {
			sum[i] = Integer.parseInt(st.nextToken());
			sum[i] = (sum[i-1]+sum[i])%M;
			cnt[sum[i]%M]++;
		}
		
		ans += ((cnt[0]*(cnt[0]+1))/2);
		
		for(int i = 1; i<M; i++) {
			ans += (((cnt[i]-1)*(cnt[i]))/2);
		}
		System.out.println(ans);
	}
}
