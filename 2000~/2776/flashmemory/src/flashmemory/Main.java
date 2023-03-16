package flashmemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			int N,M;
			//¼öÃ¸1
			N = Integer.parseInt(br.readLine());
			HashSet<Integer> S1 = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				S1.add(Integer.parseInt(st.nextToken()));
			}
			//¼öÃ¸2
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) {
				int S2 = Integer.parseInt(st.nextToken());
				if(S1.contains(S2)) {
					sb.append("1\n");
				}
				else
					sb.append("0\n");
			}
		}
		System.out.println(sb);
	}
}
