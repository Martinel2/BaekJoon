import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while(N!=0 || M!=0) {
			int cnt = 0;
			HashSet<Integer> cd = new HashSet<>();
			
			for(int i = 0; i<N; i++) {
				int num = Integer.parseInt(br.readLine());
				cd.add(num);
			}
			
			for(int i = 0; i<M; i++) {
				int num = Integer.parseInt(br.readLine());
				if(cd.contains(num))
					cnt++;
			}
			
			sb.append(cnt).append('\n');
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb);
	}
}
