import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		long ans = 0;
		long[] arr = new long[N+1];
		long[] sum = new long[N+1];
		arr[0] = 0;
		sum[0] = 0;
		for(int i = 1; i<=N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			sum[i] = sum[i-1] + arr[i]; //누적합 배열 만들기
		}
		for(int i = 1; i<N; i++) {
			//합의 곱 = 곱의 합 ex) (1+2)*3 = (1*3 + 2*3)
			ans += (sum[N]-sum[i])*arr[i]; // (x+y+z) - (x) = y+z 와 같이 원하는 범위의 합 구할 수 있음 
		}
		System.out.println(ans);
	}
}
