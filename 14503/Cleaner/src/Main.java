import java.io.*;
import java.util.*;


public class Main {
	static int N,M;
	static int cnt = 1;
	static int[][] room;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		
		room = new int[N][M];
		
		tk = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(tk.nextToken());
		int y = Integer.parseInt(tk.nextToken());
		int dir = Integer.parseInt(tk.nextToken());
		for(int i =0; i<N; i++)//초기화
		{
			tk = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++)
			{
				room[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		DFS(x,y,dir);
		System.out.print(cnt);
		
	}
	static void DFS(int x, int y, int dir) {
		room[x][y] = 2;
		boolean flag = false;
		for(int i  = 0; i < 4; i++)
		{
			dir = (dir+3)%4;
  			if(room[x+dx[dir]][y+dy[dir]] == 0) {
  				flag = true;
  				cnt++;
  				DFS(x+dx[dir], y+dy[dir], dir);
  				return;
  			}
		}
		if(!flag)//이동x
		{
			//후진하기
			dir = (dir+2)%4;
			if(room[x+dx[dir]][y+dy[dir]] != 1) {
				DFS(x+dx[dir], y+dy[dir], (dir+2)%4);
			}
			else
				return;
		}
	}
}
