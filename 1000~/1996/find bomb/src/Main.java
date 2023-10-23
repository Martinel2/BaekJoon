import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	
	static int[][] fill(int[][] ans, int x, int y, int bomb){
		
		ans[x][y] = -1;
		
		int dx = x-1;
		int dy = y-1;
		
		for(int i = dx; i<dx+3; i++) {
			if(0 <= i && i < N) {
				for(int j = dy; j<dy+3; j++) {
					if((0 <= j && j < N) && ans[i][j] != -1) {
						ans[i][j] += bomb;
					}
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		char[][] arr = new char[N][N];
		
		int[][] ans = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j = 0; j<N; j++) {
				int num = arr[i][j] - '0';
				if(1<= num && num <= 9) 
					ans = fill(ans, i, j, num);
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(ans[i][j] == -1)
					sb.append('*');
				else if(ans[i][j] >= 10)
					sb.append('M');
				else
					sb.append(ans[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
