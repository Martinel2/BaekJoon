import java.io.*;
import java.util.*;

//2096 내려가기
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][3];
		int[][] mindp = new int[N][3];
		int[][] maxdp = new int[N][3];
		int max;
		int min;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		mindp[0][0] = map[0][0]; mindp[0][1] = map[0][1]; mindp[0][2] = map[0][2];
		maxdp[0][0] = map[0][0]; maxdp[0][1] = map[0][1]; maxdp[0][2] = map[0][2];
		
		for(int i = 1; i<N; i++) {
			maxdp[i][0] = Math.max(maxdp[i-1][0],maxdp[i-1][1])+map[i][0];
			maxdp[i][1] = Math.max(maxdp[i-1][0],Math.max(maxdp[i-1][1],maxdp[i-1][2]))+map[i][1];
			maxdp[i][2] = Math.max(maxdp[i-1][1],maxdp[i-1][2])+map[i][2];
			
			mindp[i][0] = Math.min(mindp[i-1][0],mindp[i-1][1])+map[i][0];
			mindp[i][1] = Math.min(mindp[i-1][0],Math.min(mindp[i-1][1],mindp[i-1][2]))+map[i][1];
			mindp[i][2] = Math.min(mindp[i-1][1],mindp[i-1][2])+map[i][2];		
		}
		max = Math.max(Math.max(maxdp[N-1][0], maxdp[N-1][1]), maxdp[N-1][2]);
		min = Math.min(Math.min(mindp[N-1][0], mindp[N-1][1]), mindp[N-1][2]);
		System.out.println(max+" "+min);
	}
}