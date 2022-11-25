import java.io.*;
import java.util.*;


//13549 ¼û¹Ù²ÀÁú 3
public class Main {
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> cnt = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[100001];
		q.add(N);
		cnt.add(0);
		int ans = 0;
		while(!q.isEmpty())
		{
			int X = q.poll();
			int c = cnt.poll();
			
			if(X == K){
				ans = c;
				break;
			}
			else
			{
				if(X*2 <= 100000 && !visit[X*2])
				{
					visit[X*2] = true;
					q.add(X*2);
					cnt.add(c);
				}
				if(X-1 >= 0 && !visit[X-1])
				{
					visit[X-1] = true;
					q.add(X-1);
					cnt.add(c+1);
				}
				if(X+1 <= 100000 && !visit[X+1])
				{
					visit[X+1] = true;
					q.add(X+1);
					cnt.add(c+1);
				}
			}
		}
		
		System.out.print(ans);
	}
}