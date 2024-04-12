import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		//최소 맥박 값
		int mix = m;
		//반복 값 저장할 변수
		int count = 0;
		
		//운동을 한번도 못할 경우 -1 출력
		if((M - m) < T) {
			System.out.println(-1);
		}else {
			//무한루프
			while(true) {
				
				if((m + T) <= M) {
					m += T;
					N--;
				}else {
					m -= R;
				}
				
				//쉬었을때 값이 최소 맥박보다 낮으면 최소 맥박 저장
				if(m < mix) {
					m = mix;
				}
				
				count++;
				
				//주어진 운동 횟수를 다 하면 무한루프 종료
				if(N == 0) break;
			}
			System.out.println(count);
		}
	}

}
