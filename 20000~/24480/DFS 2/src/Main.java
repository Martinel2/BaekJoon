import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//24480
public class Main {
	
	static int[] edge;
	static int[][] vertex;
	static int N;
	
	static void dfs(int seq, int idx) {
		edge[idx] = seq;
		for(int i = N-1; i>=0; i--) {
			if(vertex[idx][i] == 1 && edge[i] == 0)
				dfs(seq+1, i);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M,R;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken())-1;
		
		edge = new int[N];
		vertex = new int[N][N];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			vertex[x][y] = 1;
			vertex[y][x] = 1;
		}
		
		dfs(1,R);
		for(int seq : edge) {
			sb.append(seq).append('\n');
		}
		
		System.out.println(sb);
	}
}
