import java.io.*;
import java.util.*;


//2669 직사각형 네개의 합집합의 면적 구하기
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int[][] paper = new int[100][100];
		int ans = 0;
		for(int i = 0; i<4; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			
			for(int m = sx; m<dx; m++)
				for(int n = sy; n<dy; n++)
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