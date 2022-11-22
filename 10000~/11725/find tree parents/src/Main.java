import java.io.*;
import java.util.*;


//11725 트리의 부모찾기
public class Main {
	static int N;
	static int[][] arr;
	static boolean [] visit;
	static boolean dfs(int start, int end) {
		if(end == 1) {
			return true;
		}
		else {
			for(int i = 1; i<=N; i++) {
				boolean flag = false;
				if(arr[end][i] == 1 && !visit[i])
				{
					visit[i] = true;
					flag = dfs(end,i);
					visit[i] = false;
				}
				if(flag)
					return true;
			}
			return false;
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		//초기화
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1; arr[b][a] = 1;
		}
		
		//dfs
		for(int i = 2; i<=N; i++) {
			visit[i] = true;
			for(int j = 1; j<=N; j++) {
				boolean flag = false;
				if(arr[i][j] == 1) {
					visit[j] = true;
					flag = dfs(i,j);
					visit[j] = false;
					if(flag) {
						sb.append(j).append("\n");
						break;
					}
				}
			}
			visit[i] = false;
		}
		System.out.print(sb);
	}
}