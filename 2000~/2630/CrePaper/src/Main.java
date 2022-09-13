import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int board[][] = new int[N][N];
		for(int i =0; i<N; i++)
		{
			String[] s = br.readLine().split(" ");
			for(int j = 0; j<N; j++)
			{
				board[i][j] = Integer.parseInt(s[j]);
			}
		}
		DFS(0,0,N,board);
		System.out.println(cntw);
		System.out.println(cntb);
	}
	static int cntw=0;
	static int cntb=0;
	static int i,j;
	static void DFS(int x, int y, int N, int[][] board)
	{

		int ck = board[x][y];
		int n2 = (int) N/2;
		for(i = x; i<x+N; i++)
		{
			for(j = y; j<y+N; j++)
			{
				if(ck != board[i][j]) {
					break;
				}
			}
			if(j != y+N)
				break;
		}
		if(i == x+N && j == y+N || n2 == 0)
		{
			if(ck == 1)
				cntb++;
			else if(ck == 0)
				cntw++;
		}
		else
		{
			int nx,ny;
			int a,b;
			for(a = 0; a<2; a++)
			{
				for(b = 0; b<2; b++)
				{
					nx = x + (n2 * a);
					ny = y + (n2 * b);
					DFS(nx,ny,n2,board);
				}
			}	
		}
		
	}

}
