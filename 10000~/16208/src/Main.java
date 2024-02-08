import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		long ans = 0;
		long sum = 0;
		int[] arr = new int[n];
		st= new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		for(int i = n-1; i>=0; i--) {
			sum -= arr[i];
			ans += sum*arr[i];
		}
		
		System.out.println(ans);
	}
}
