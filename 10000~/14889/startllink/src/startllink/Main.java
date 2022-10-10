package startllink;
import java.io.*;
import java.util.*;


//14889 스타트와 링크
public class Main {
	
	static int team;
	static int[][] arr;
	static int[] start;
	static int[] link;
	static boolean[] s;
	static int min = 100000;
	static void back(int cnt) {
		if(cnt == team)
		{
			int steam = 0;
			int lteam = 0;
			int lnum = 0;
			for(int i = 0; i<team*2; i++)
			{
				if(!s[i]) {
					link[lnum] = i;
					lnum++;
				}
			}
			for(int i = 0; i<team-1; i++)
			{
				for(int j = i+1; j<team; j++)
				{
					steam += arr[start[i]][start[j]] + arr[start[j]][start[i]];
					lteam += arr[link[i]][link[j]] + arr[link[j]][link[i]];
				}
			}
			if(min > Math.abs(lteam - steam))
				min = Math.abs(lteam - steam);
		}
		else
		{
			for(int i = 0; i<team*2; i++)
			{
				if(!s[i])
				{
					start[cnt] = i;
					s[i] = true;
					back(cnt+1);
					s[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		team = N/2;
		start = new int[team];
		link = new int[team];
		s = new boolean[N];
		for(int i = 0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		back(0);
		System.out.println(min);
	}
}