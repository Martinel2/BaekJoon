package title;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] l = new long[90];
	static StringBuilder sb = new StringBuilder();
	static void title(long N, long K){
		//System.out.println(N+" "+K+" "+l[(int) (N-2)]+" "+l[(int) N]);
		//첫번째문자는 무조건 (
		if(K == 1)
			sb.append("(\n");
		//마지막 문자는 무조건 )
		else if(K==l[(int)N]){
			sb.append(")\n");
		}
		// 반을 갈랐을때 왼쪽에 K가 존재
		else if(2 <= K && K <= 1 + l[(int)(N-2)]) {
			title(N-2,K-1);
		}
		// 반을 갈랐을때 오른쪽에 K가 존재
		else if(2 + l[(int)(N-2)] <= K && K <= l[(int)N]-1 ) {
			title(N-1,K-l[(int)(N-2)]-1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = 85; // 범위의 최대치인 N의 값
		int T = Integer.parseInt(br.readLine());
		
		l[1] = 2;
		l[2] = 2;
		// 범위내의 길이 구하기
		for(int i = 3; i<90; i++){
			l[i] = l[i-1]+l[i-2] + 2;
		}	
		for(int t = 0; t<T; t++) {
			long N,K;
			st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken()); // Sn
			K = Long.parseLong(st.nextToken()); //인덱스
			
			if(N <= M) {
				if(l[(int)N] < K)
					sb.append("0\n");
				else
					title(N,K);
			}
			else { // 무조건 K범위 이내
				long n,k;
				n = N - Math.floorDiv((N-M), 2)*2;
				k = K - Math.floorDiv((N-M), 2);
				//System.out.println(n+" "+k);
				if(k <= 0) {
					sb.append("(\n");
				}
				else {
					title(n,k);
				}	
			}
		}
		System.out.println(sb);
	}
}
/*
1
1000000000000000000 1000000000000000000

l[84] = 642,002,575,265,468,350
1,000,000,000,000,000,000
500,000,000,000,000,043

57,889,336,098,704,882
9,553,674,227,107,317
*/