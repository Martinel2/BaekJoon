import java.io.*;
import java.util.*;


//2563 »öÁ¾ÀÌ 
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		int ans = 0;
		for(int i = 0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int m = x; m<x+10; m++)
				for(int n = y; n<y+10; n++)
					paper[m][n] = 1;
		}
		for(int x = 0; x<100; x++)
		{
			for(int y = 0; y<100; y++)
			{
				if(paper[x][y] == 1)
					ans++;
				else
					continue;
			}
		}
		System.out.println(ans);
	}
}