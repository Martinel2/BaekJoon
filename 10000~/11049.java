package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] matrix = new int[N+1][2];
		int[][] dp = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			matrix[i][0] = row;
			matrix[i][1] = col;
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)
				dp[i][j] = matrix[i][0]*matrix[i][1]*matrix[j][1];
		}
		
		for(int i = 1; i<N-1; i++) {
			for(int j = 0; i+j<N; j++) {
				dp[j][i+j] = 1000000000;
				for(int k = j; k<i+j; k++) {
					// dp[j][i+j] = j~i+j���� ����� ������ ���� �ּҰ�
					// k�� �������� �� �κ����� ������ ���� �κк��� ���� ���� ��, ���� �� �κ��� ����
					// dp[j][k] + dp[k+1][i+j] = j~k������ �ּҰ� + k+1~i+j������ �ּҰ�
					// matrix[j][0] * matrix[k][1] * matrix[i+j][1] 
					//			= [j][0]X[k][1]��İ� [k+1][0]X[i+j][1] ����� ��
					dp[j][i+j] = Math.min(dp[j][i+j], 
							(dp[j][k] + dp[k+1][i+j])+(matrix[j][0]*matrix[k][1]*matrix[i+j][1]) );
				}
			}
		}
		
		System.out.println(dp[0][N-1]);
	}
}