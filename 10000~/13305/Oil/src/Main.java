import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dist = new long[N - 1];	// �Ÿ�
		long[] cost = new long[N];	// ��� 
		
		// �Ÿ� �Է� 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N - 1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		// ���ʹ� �⸧�� �Է�
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		
		long sum = 0;
		long minCost = cost[0];	// ���� ������ ���� �� ���� �ּ� ��� 
 
		for(int i = 0; i < N - 1; i++) {
			
			/*
			 *  ���� �����Ұ� ���� �������� �⸧������ �� ���
			 *  minCost�� �������ش�. 
			 */
			if(cost[i] < minCost) {
				minCost = cost[i];
			}
			
			sum += (minCost * dist[i]);
		}
		
		System.out.println(sum);
		
	}
}