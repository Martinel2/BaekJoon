import java.io.*;
import java.util.*;




public class SL {
	static Queue<Integer>  Q = new LinkedList<>(); 
	
	static int dx[] = {1,2,3,4,5,6};
	static int[] a = new int[101];
	static int[] ladder = new int[101];
	static int[] snake = new int[101];
	
	static void BFS()
	{
		while(!Q.isEmpty())
		{
			int player = Q.poll();
			if(ladder[player]>0)
			{
				int cnt = a[player];
				player = ladder[player];
				
				for(int i =0; i<6; i++)
				{
					int nx = player + dx[i]; 
					if(nx<=100) {
						if(a[nx] == 0 || a[nx] > cnt+1 )
						{
							Q.add(nx);
							a[nx] = cnt + 1;
						}
					}
				}
			}
			else if(snake[player]>0)
			{
				int cnt = a[player];
				player = snake[player];
				for(int i =0; i<6; i++)
				{
					int nx = player + dx[i]; 
					if(nx<=100) {
						if(a[nx] ==0 || a[nx] > cnt+1 )
						{
							Q.add(nx);
							a[nx] = cnt + 1;
						}
					}
				}
			}
			else
			{
				for(int i=0; i<6; i++)
				{
					int nx = player + dx[i];
					
					if(nx <= 100) {
						if(a[nx] == 0 || a[nx] > a[player]+1)
						{
							Q.add(nx);
							a[nx] = a[player] + 1;
						}
					}
				}
			}
			
			
		}
	}
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(a, 0);
		Arrays.fill(ladder, 0);
		Arrays.fill(snake, 0);
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		for(int i=0 ; i<N; i++)
		{
			s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			ladder[u] = v;
		}
		
		for(int i=0 ; i<M; i++)
		{
			s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			snake[u] = v;
		}
		Q.add(1);
		BFS();
		System.out.println(a[100]);
			
		
	}
}
