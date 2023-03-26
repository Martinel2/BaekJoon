package fibonacci;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

 //11444 �Ǻ���ġ�� 6
public class Main {
	
	final static long MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
 
		long N = Long.parseLong(br.readLine());
		
		// N�� 1�̰ų� 0�̶�� N�� ����ϰ� ����
		if(N == 1 || N == 0) {
			System.out.println(N);
			return;
		}
		
		// A^(n-1)�� [0][0] ���Ҹ� ���ϸ� �ǹǷ� 1�� ���ش�. 
		N--;
		
		long[][] origin = {{1, 1},{1, 0}};
		long[][] A = {{1, 0},{0, 1}};	// �ʱ� ���� �������(I)�� �ʱ�ȭ���ش�.
		
		/*
		 * origin ����� ���� loop���� �������� �����ִ� ����̰�,
		 * A�� ������ Ȧ �� �� ��, ���� loop���� ���� ���� ����� origin��
		 * ���� A ����� �����ִ� ������� ����.
		 * 
		 * ��, ��� ������ �������� ��ġ�� �ȴ�.
		 * 
		 * ex)
		 * A^11 ������ ��,
		 * 
		 * N = 11 (N % 2 == 1) -> I * A^1 = A^1 (result)
		 *                     -> A^1 * A^1 = A^2 (origin)
		 *                     
		 * N = 5  (N % 2 == 1) -> A^1 * A^2 = A^3 (result)
		 *                     -> A^2 * A^2 = A^4 (origin)
		 *                     
		 * N = 2  (N % 2 == 0) -> A^4 * A^4 = A^8 (origin)
		 *
		 * N = 1  (N % 2 == 1) -> A^3 * A^8 = A^11 (result)
		 *                     -> A^8 * A^8 = A^16 (origin)  
		 */
		while(N > 0) {
			
			// ������ Ȧ����� origin �迭�� �� �� �� �����ش�.
			if(N % 2 == 1) {	// b % 2 == 1 �� (b & 1L) != 0L ���ε� ������ �� �ִ�.
				A = multiply(A, origin);
			}
			origin = multiply(origin, origin);
			
			N /= 2;
		}
		
		System.out.println(A[0][0]);
		
	}
	
	// o1�� o2 ����� �����ִ� �޼ҵ�
	public static long[][] multiply(long[][] o1, long[][] o2) {
		
		long[][] ret = new long[2][2];
 
		ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
		ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
		ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
		ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;
 
		
		// �ݺ������� �ۼ����־ ������
		/*
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 2; i++) {							
				for (int j = 0; j < 2; j++) {
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		*/
		return ret;
	}
}