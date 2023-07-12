import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//17070
public class Main {
	
	static int[][] house;
	static int cnt = 0;
	static int row = 0, col = 1, dia = 2;
	static int N;
	
	static boolean[][][] visit;

	
	static boolean isPossRow(int x, int y) {
		if(y+1 <= N && house[x][y+1] != 1)
			return true;
		else return false;
	}
	
	static boolean isPossCol(int x, int y) {
		if(x+1 <= N && house[x+1][y] != 1)
			return true;
		else return false;
	}
	
	static boolean isPossDia(int x, int y) {
		if( (y+1 <= N && x+1 <= N) 
				&& (house[x][y+1] != 1 && house[x+1][y] != 1 && house[x+1][y+1] != 1) )
			return true;
		else return false; 
	}
	
	static void dfs(int type, int x, int y)
	{
		if(x == N && y == N) {
			cnt++;
			return;
		}
		else {
			if(type == row) {
					if(isPossRow(x,y)) {
						dfs(row, x, y+1);
					}
					if(isPossDia(x,y)) {
						dfs(dia, x+1, y+1);
					}
			}
			else if(type == col) {
					if(isPossCol(x,y)) {
						dfs(col, x+1, y);
					}
					if(isPossDia(x,y)) {
						dfs(dia, x+1, y+1);
					}
			}
			else {
					if(isPossRow(x,y)) {
						dfs(row, x, y+1);
					}
					if(isPossCol(x,y)) {
						dfs(col, x+1, y);
					}
					if(isPossDia(x,y)) {
						dfs(dia, x+1, y+1);
					}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		house = new int[N+1][N+1];
		visit = new boolean[3][N+1][N+1];
		
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}		
		}
		dfs(row,1,2);
		System.out.println(cnt);
	}
}

/*
6
0 0 0 0 0 0
0 1 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0 
 */
