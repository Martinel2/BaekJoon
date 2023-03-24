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
		//ù��°���ڴ� ������ (
		if(K == 1)
			sb.append("(\n");
		//������ ���ڴ� ������ )
		else if(K==l[(int)N]){
			sb.append(")\n");
		}
		// ���� �������� ���ʿ� K�� ����
		else if(2 <= K && K <= 1 + l[(int)(N-2)]) {
			title(N-2,K-1);
		}
		// ���� �������� �����ʿ� K�� ����
		else if(2 + l[(int)(N-2)] <= K && K <= l[(int)N]-1 ) {
			title(N-1,K-l[(int)(N-2)]-1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = 85; // ������ �ִ�ġ�� N�� ��
		int T = Integer.parseInt(br.readLine());
		
		l[1] = 2;
		l[2] = 2;
		// �������� ���� ���ϱ�
		for(int i = 3; i<90; i++){
			l[i] = l[i-1]+l[i-2] + 2;
		}	
		for(int t = 0; t<T; t++) {
			long N,K;
			st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken()); // Sn
			K = Long.parseLong(st.nextToken()); //�ε���
			
			if(N <= M) {
				if(l[(int)N] < K)
					sb.append("0\n");
				else
					title(N,K);
			}
			else { // ������ K���� �̳�
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