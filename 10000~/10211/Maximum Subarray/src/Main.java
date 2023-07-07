import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10211
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int ans = -1001;
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				max = Math.max(max + num, num);
				if(ans < max)
					ans = max;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
