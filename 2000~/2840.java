package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 바퀴 칸의 개수
		int K = Integer.parseInt(st.nextToken()); // 회전 횟수
		
		char[] arr = new char[N];
		Arrays.fill(arr, '?'); // 모든 칸에 '?'를 채운다.
	
		
		int idx = 0;
		for(int i=0; i<K; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			// N은 최대 25, S는 최대 100이 나올 수 있으므로 한 번에 여러 바퀴를 돌릴 수 있다.
			int S = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			
			// 바퀴가 시계방향으로 돈다 == 화살표는 반시계방향으로 돈다
            // 여러 바퀴 돌 수 있으므로 나머지를 구해 idx가 바퀴 칸 갯수를 넘지 않도록 해준다.
			idx -= S % N;
			if(idx < 0) {
				idx += N;
			}
			
			// 이미 차 있는 자리에 다른 문자가 또 등장하면
			if(arr[idx] != '?' && arr[idx] != c) {
				System.out.println("!");
				return;
			}
			
			arr[idx] = c;
		}
		
		// 다른 자리에 같은 문자가 있으면
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr[i] != '?' && arr[i] == arr[j]) {
					System.out.println("!");
					return;
				}
			}
		}
		
		// 출력
		for(int i=0; i<N; i++) {
			sb.append(arr[(idx + i) % N]);
		}
		
		System.out.println(sb);
	}
	
}