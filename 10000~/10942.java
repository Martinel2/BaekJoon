package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	//�Է¹޴� ����ü�� ���ڷ� ����. - �ڸ����� ���� ���ܳ��� �縰����� ����
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		st =new StringTokenizer(br.readLine());
		
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = 1; //�ڱ��ڽ��� �縰����̴�.
		}
		
		for(int i=1; i<n; i++){
            if(arr[i] == arr[i+1]) //�ڽ��� �ռ��ڿ� ������
                dp[i][i+1] = 1;//�� ���� ��ġ�� �縰����̴�.
        }
		
		for(int k=2; k<n; k++){
            for(int i=1; i<n; i++){
            	//�� ������ ����, �� ������ ���̿� �ִ� ������ �縰����� ������ ��
                if(i+1 <= n && i+k <= n && dp[i+1][i+k-1] == 1 && arr[i] == arr[i+k])
                    dp[i][i+k] = 1; // �ش� ���� �縰����̴�.
            }
        }
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(dp[s][e]).append('\n');
		}
		
		System.out.println(sb);
    }
}
