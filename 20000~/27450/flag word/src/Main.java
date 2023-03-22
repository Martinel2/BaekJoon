import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class flag{
		int idx;//대사를 한 칸의 인덱스
		long cnt;//대사횟수
		
		flag(int idx, long cnt){
			this.idx = idx;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N,K;
		N = Integer.parseInt(st.nextToken());//부하의 수
		K = Integer.parseInt(st.nextToken());//목소리의 크기
		
		long[] cur = new long[N+1];//현재 강함
		long[] aim = new long[N+1];//목표 강함

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			cur[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			aim[i] = Long.parseLong(st.nextToken());
		}
		
		Queue<flag> Q = new LinkedList<>();
		long[] upcase = new long[N+1];//대사횟수 저장
		long cnt = 0;
		long up = 0;
		for(int i = 1; i<=N; i++) {
			upcase[i] = upcase[i-1];
			up -= upcase[i];
			if(!Q.isEmpty() && Q.peek().idx - i <= 0) {
				upcase[i] -= Q.poll().cnt;				
			}
			long sum = cur[i]+up;
			//강해져야 할때
			if(sum < aim[i]) {
				//목표강함만큼 커지게
				long cou = (long)Math.ceil((double)(aim[i] - sum)/(double)K);
				Q.add(new flag((i+K), cou));
				cnt += cou;
				upcase[i] += cou;
				up += cou*K;
			}
			//System.out.println(up);
		}
		System.out.println(cnt);
	}
}
