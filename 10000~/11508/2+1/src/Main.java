import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] price = new int[N];
		int ans = 0;
		
		for(int i = 0; i<N; i++) {
			price[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(price);
		
		int idx = N-1;
		int cnt = 0;
		while(idx >= 0) {
			if(cnt == 2) {
				cnt = 0;
				idx--;
			}
			else {
				ans += price[idx];
				cnt++;
				idx--;
			}
		}
		
		System.out.println(ans);
	}
}
