package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			//a b c
			//d e f
			//a-d a-e- a-f
			//b-d b-e b-f
			//c-d c-e c-f
			//이걸 B번
			
			//A = k*B
			//총 경기수 = (k*B)*n*m*(m-1)/2 + B*(n*m*m*(n-1))/2 = B*(k*m! + m*m*(n-1)) <= D
			// 2 3 3 60
			// B*(3*6 + 3*3*2) = 36*B
			//B = 2, 54
			
			long cd = n*m*( k*(m-1) + m*(n-1) );
			double b = Math.floor((2*d)/(cd));
			long ans = (long)(b*(cd/2));
			if(ans > 0)
				sb.append(ans).append('\n');
			else
				sb.append(-1).append('\n');
		}
		System.out.println(sb);
	}
}