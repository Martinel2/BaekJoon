import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] level = new int[N];
		for(int i = 0; i<N; i++) {
			level[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		int max = level[N-1];
		for(int i = N-2; i>=0; i--) {
			if(max <= level[i]) {
				ans += (level[i]-max)+1;
				level[i] = max -1;
				max = level[i];
			}
			else
				max = level[i];
			
		}
		System.out.println(ans);
	}
}
