import java.io.*;
import java.util.*;


//1992 쿼드트리
public class Main {
	static char[][] paint;
	static StringBuilder sb = new StringBuilder();
	
	static void quadtree(int ux,int uy, int dx, int dy, int N)//d는 제곱수
	{
		boolean check = false;
		char num = paint[ux][uy];
		for(int i = ux; i<dx; i++)
		{
			for(int j = uy; j<dy; j++)
			{
				if(num != paint[i][j])
				{
					check = true;
					break;
				}
			}
			if(check)
				break;
		}
		if(!check)
		{
			sb.append(num);
			return;
		}
		else
		{
			N /= 2;
			int divx = ux+N;
			int divy = uy+N;
			sb.append("(");
			quadtree(ux,uy,divx,divy,N); //왼쪽위
			quadtree(ux,divy,divx,dy,N); //오른쪽위
			quadtree(divx,uy,dx,divy,N); //왼쪽아래
			quadtree(divx,divy,dx,dy,N); //오른쪽아래
			sb.append(")");
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		paint = new char[N+1][N+1];
		for(int i = 0; i<N; i++)
			paint[i] = br.readLine().toCharArray();
		
		quadtree(0,0,N,N,N);
		System.out.print(sb);
	}
	
}