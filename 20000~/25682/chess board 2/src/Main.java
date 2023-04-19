import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//25682
public class Main {
	
	static char[][] board; 
	static int N,M,K;
	static int minboard(char color) {
		int cnt = Integer.MAX_VALUE;
		int[][] sum = new int[N+1][M+1];
		int value;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if((i+j)%2 == 0) {
					if(board[i][j] != color)
						value = 1;
					else
						value = 0;
				}
				else {
					if(board[i][j] == color)
						value = 1;
					else
						value = 0;
				}
				sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] - sum[i][j] + value;			
			}
		}
		
		for(int i = 1; i<=N-K+1; i++) {
			for(int j = 1; j<=M-K+1; j++) {
				cnt = Math.min(cnt, sum[i+K-1][j+K-1] - sum[i+K-1][j-1] - sum[i-1][j+K-1] + sum[i-1][j-1]);
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new char[N][M]; 
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<M; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		System.out.println(Math.min(minboard('B'), minboard('W')));
	}
}
