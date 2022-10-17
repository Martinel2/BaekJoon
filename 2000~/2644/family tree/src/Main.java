import java.io.*;
import java.util.*;


//2644 ÃÌ¼ö °è»ê 
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N+1][N+1];
		
		boolean visit[] = new boolean[N+1];
		int cnt[] = new int[N+1];
		
		st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i<m; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		visit[a] = true;
		while(!q.isEmpty()) {
			int p  = q.poll();
			
			if(p == b)
				break;
			for(int i = 1; i< arr.length; i++) {
				if(arr[p][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
					cnt[i] = cnt[p] +1;
				}
			}
		}
		if(cnt[b] == 0)
			System.out.println(-1);
		else
			System.out.println(cnt[b]);
	}
}