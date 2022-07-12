import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		
		alpa = new char[R][C];
		adder = new int[R][C];
		visit = new boolean[26];
		for(int i =0; i<R; i++)
		{
			alpa[i] = br.readLine().toCharArray();
		}
		adder[0][0] = 1;
		DFS(0,0);
		System.out.println(max);
		
	}
	static char[][] alpa;
	static int[][] adder;
	static boolean[] visit;
	static int max = 1;
	static int R;
	static int C;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static void DFS(int x, int y)
	{
		
		visit[alpa[x][y] - 65] = true;
		for(int i = 0; i<4; i++)
		{
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(0<=nx && nx<R && 0<=ny && ny<C)
			{
				if(!visit[alpa[nx][ny]-'A']) {
					adder[nx][ny] = adder[x][y] + 1;
					if(adder[nx][ny] > max)
						max = adder[nx][ny];
					DFS(nx,ny);
					visit[alpa[nx][ny]-'A'] = false;
				}
			}
		}
		visit[alpa[x][y]-'A'] = false;
		
	}
}
