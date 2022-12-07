import java.io.*;
import java.util.*;

//11048 이동하기
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = {0,1,1};
		int[] dy = {1,0,1};
		int[][] map;
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];

		for(int i = 0 ; i<N; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				for(int k = 0; k<3; k++) {
					int nx = i-dx[k];
					int ny = j-dy[k];
					if( (0 <= nx && nx < N) && (0 <= ny && ny < M) ) {
						if(map[nx][ny]+num > map[i][j])
							map[i][j] = map[nx][ny]+num;
					}
					
				}
			}
		}
		
		System.out.println(map[N-1][M-1]);
	}
}
