import java.io.*;
import java.util.*;

//10974 모든순열
public class Main {
	public static int N;
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	static void backtracking(int cnt)
	{
		if(cnt == N)
		{
			for(int i : arr)
				sb.append(i+ " ");
			sb.append("\n");
			return;
		}
			
		else
		{
			for(int i= 1; i<=N; i++)
			{
				if(visit[i-1])
					continue;
				arr[cnt] = i;
				visit[i-1] = true;
				backtracking(cnt+1);
				visit[i-1] = false;
			}
		}
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visit = new boolean[N];
		for(int i = 1; i<=N; i++)
		{
			arr[0] = i;
			visit[i-1] = true;
			backtracking(1);
			visit[i-1] = false;
		}
		System.out.println(sb);
	}
}
