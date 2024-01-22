package sheep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class S{
		int x;
		int y;
		
		S(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int r,c;
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		char[][] arr = new char[r][c];
		boolean[][] visit = new boolean[r][c];
		int wolf = 0;
		int sheep = 0;
		ArrayList<S> v = new ArrayList<>();
		
		for(int i = 0; i<r; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j = 0; j<c; j++) {
				if(arr[i][j] == 'v') {
					wolf++;
					v.add(new S(i,j));
				}
				else if(arr[i][j] == 'o')
					sheep++;
			}
		}
		
		for(S s : v) {
			Queue<S> bfs = new LinkedList<>();
			bfs.add(s);
			int areaW = 0;
			int areaS = 0;
			while(!bfs.isEmpty()) {
				S siu = bfs.poll();
				int x = siu.x;
				int y = siu.y;
				visit[x][y] = true;
				if(arr[x][y] == 'v')
					areaW++;
				else if(arr[x][y] == 'o')
					areaS++;
				for(int i = 0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(((0<nx && nx<r-1) && (0<ny && ny<c-1))
							&& !visit[nx][ny] && (arr[nx][ny] != '#')) {
						visit[nx][ny] = true;
						bfs.add(new S(nx,ny));
					}
				}
			}
			if(areaW < areaS)
				wolf -= areaW;
			else
				sheep -= areaS;
		}
		
		System.out.print(sheep + " " + wolf);
	}
}
