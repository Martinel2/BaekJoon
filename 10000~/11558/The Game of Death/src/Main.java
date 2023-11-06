import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			HashMap<Integer,Integer> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 1; i<=N; i++) {
				int num = Integer.parseInt(br.readLine());
				
				map.put(i, num);
			}
			
			int cnt = 0;
			int idx = 1;
			while(idx != N && cnt <= N) {
				idx = map.get(idx);
				cnt++;
			}
			if(cnt > N)
				cnt = 0;
			
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}
}
