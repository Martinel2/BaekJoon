import java.util.*;
import java.io.*;

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
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
	}
	static int cnt1=0;
	static int cnt2=0;
	static int cnt3=0;
	static int i,j;
	static void DFS(int x, int y, int N, int[][] board)
	{

		int ck = board[x][y];
		int n3 = (int) N/3;
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
		if(i == x+N && j == y+N || n3 == 0)
		{
			if(ck == -1)
				cnt1++;
			else if(ck == 0)
				cnt2++;
			else if(ck == 1)
				cnt3++;
		}
		else
		{
			int nx,ny;
			int a,b;
			for(a = 0; a<3; a++)
			{
				for(b = 0; b<3; b++)
				{
					nx = x + (n3 * a);
					ny = y + (n3 * b);
					DFS(nx,ny,n3,board);
				}
			}	
		}
		
	}
}