import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int pick(int[] num) {
		int max = 0;
		for(int i = 0; i<3; i++) {
			for(int j = i+1; j<4; j++) {
				for(int k = j+1; k<5; k++) {
					int n = (num[i] + num[j] + num[k])%10;
					if(max < n)
						max = n;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int max = 0;
		int ans = 1;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] num = new int[5];
			for(int j = 0; j<5; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			int one = pick(num);
			if(max <= one) {
				ans = i+1;
				max = one;
			}
		}
		System.out.println(ans);
	}
}
