package lottery;
import java.io.*;
import java.util.*;


//6603 ·Î¶Ç
public class Main {
	static int flag = 0;
	static boolean[] visited;
	static int[] arr;
	static int[] ans;
	public static StringBuilder sb = new StringBuilder();
	
	public static void print(int cnt,int k) {
		
		if(cnt == 6) {
			for(int val : ans) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i<flag; i++)
		{
				if(k>arr[i] || visited[i])
					continue;
				int num = arr[i];
				ans[cnt] = num;
				visited[i] = true;
				print(cnt+1, num);
				visited[i] = false;
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		flag = Integer.parseInt(st.nextToken());
		
		while(flag != 0)
		{
			arr = new int[flag];
			ans = new int[6];
			for(int i = 0; i<flag; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			visited = new boolean[flag];
			print(0,arr[0]);
			sb.append("\n");
			st = new StringTokenizer(br.readLine(), " ");
			flag = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);
	}
}