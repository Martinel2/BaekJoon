import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		for(int i = N; i>1; i--) {
			int cnt = dp[i];
			
			//3���� ����������� 3���� ������
			if(i % 3 == 0) {
				int idx = i/3;
				if(dp[idx] == 0)
					dp[idx] = cnt+1;
				else
					dp[idx] = Math.min(cnt+1, dp[idx]);
			}
			
			//2�� ����������� 2�� ������
			if(i % 2 == 0) {
				int idx = i/2;
				if(dp[idx] == 0)
					dp[idx] = cnt+1;
				else
					dp[idx] = Math.min(cnt+1, dp[idx]);
			}
			
			//1�� ����
			if(dp[i-1] == 0)
				dp[i-1] = cnt+1;
			else
				dp[i-1] = Math.min(dp[i-1], cnt+1);
		}
		
		int[] arr = new int[dp[1]+1]; // dp[1]�� �ּҰ�. N�� �����ؾ��ϹǷ� +1
		
		//1���� ������ Ž���ؼ� ���� ���ϱ�
		int idx = 1; // 1���� ����
		int cnt = dp[1]; // ������������ �����ϱ� ���� ���������� ����
		
		while(idx <= N) {
			arr[cnt--] = idx;
			
			if(idx * 3 <= N && dp[idx]-1 == dp[idx*3]) // 3���� ���ϱ�
				idx *= 3;
			else if(idx * 2 <= N && dp[idx]-1 == dp[idx*2]) //2�� ���ϱ�
				idx *= 2;	 
			else if(idx + 1 <= N && dp[idx]-1 == dp[idx+1]) //1 ���ϱ�
				idx += 1;
			else
				break;
			
		}
		
		// ��� //
		System.out.println(dp[1]);
		for(int i = 0; i<=dp[1]; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}
