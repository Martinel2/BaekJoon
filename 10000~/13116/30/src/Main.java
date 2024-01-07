import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] parent = new int[1024];
		int[] depth = new int[1024];
		int pow = 0;
		
		for(int i = 1; i<512; i++) {
			parent[i*2] = i;
			parent[i*2+1] = i;
			if(i < Math.pow(2, pow)) {
				depth[i] = pow;
			}
			else {
				pow++;
				depth[i] = pow;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a > b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			
			while(depth[a] != depth[b]) {
				b = parent[b];
			}
			
			//System.out.println(a+" "+b);
			while(a != b) {
				a = parent[a];
				b = parent[b];
			}
			sb.append(a*10).append('\n');
		}
		
		System.out.println(sb);
	}
}
