import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		long ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<n; i++) {
			long num = (arr[n]-arr[i])*(arr[i]-arr[i-1]);
			ans += num;
		}
		System.out.println(ans);
	}
}
