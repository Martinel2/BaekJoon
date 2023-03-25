import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] set;
	
	static int find(int p) {
		if(p == set[p])
			return p;
		else
			return find(set[p]);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N,M;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//1~N까지 포함 집합
		M = Integer.parseInt(st.nextToken());// 연산의 갯수
		
		//집합 초기화
		set = new int[N+1];
		for(int i = 0; i<=N; i++) {
			set[i] = i;
		}
		
		//연산
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken()); // 연산종류
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//합집합
			if(op == 0) {
				if(a<b) {
					set[a] = b;
				}
				else
					set[b] = a;
					
			}
			else { // 포함 확인
				if(find(a) == find(b))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}
		System.out.println(sb);
		
	}
}
