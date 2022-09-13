import java.io.*;
import java.util.*;


public class mino {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int board[][] = new int[N][M];
		boolean visit[][] = new boolean[N][M];
		for(int i =0; i<N; i++)//종이 초기화
		{
			s = br.readLine().split(" ");
			for(int j = 0; j<M; j++)
			{
				board[i][j] = Integer.parseInt(s[j]);
			}	
		}
		for(int i =0; i<N; i++)//브루스포스
		{
			for(int j = 0; j<M; j++)
			{
				Plus(i,j,1,0,board,visit);
				visit[i][j] = false;
				oh(i,j,board);
			}	
		}
		System.out.print(max);
		
	}
	static int M,N;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int max = 0;
	static void Plus(int x, int y, int cnt, int sum, int[][] board, boolean[][] visit)
	{
		sum += board[x][y];
		if(cnt == 4)
		{
			if(max < sum)
				max = sum;
		}
		else
		{
			visit[x][y] = true;
			int nx,ny;
			for(int i =0; i<4; i++)
			{
				nx = x+dx[i];
				ny = y+dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M && !visit[nx][ny])
				{
					visit[nx][ny] = true;
					Plus(nx,ny,cnt+1,sum,board,visit);
					visit[nx][ny] = false;
				}
			}
		}
	}
	static void oh(int x, int y, int[][] board)
	{
		if(0<=x-1 && 0<=y-1 && y+1<M)//ㅗ
		{
			if(max < board[x][y] + board[x-1][y] + board[x][y-1] + board[x][y+1] )
				max = board[x][y] + board[x-1][y] + board[x][y-1] + board[x][y+1];
		}
		if(0<=x-1 && 0<=y-1 && x+1<N)//ㅓ
		{
			if(max < board[x][y] + board[x-1][y] + board[x][y-1] + board[x+1][y] )
				max = board[x][y] + board[x-1][y] + board[x][y-1] + board[x+1][y];
		}
		if(0<=x-1 && x+1<N && y+1<M)//ㅏ
		{
			if(max < board[x][y] + board[x-1][y] + board[x+1][y] + board[x][y+1] )
				max = board[x][y] + board[x-1][y] + board[x+1][y] + board[x][y+1];
		}
		if(x+1<N && 0<=y-1 && y+1<M)//ㅜ
		{
			if(max < board[x][y] + board[x+1][y] + board[x][y-1] + board[x][y+1] )
				max = board[x][y] + board[x+1][y] + board[x][y-1] + board[x][y+1];
		}
	}
}
