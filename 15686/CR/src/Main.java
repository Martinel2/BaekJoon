import java.io.*;
import java.util.*;


public class Main {
	
	static int N,M,H,C;
	static int[][] city;
	static int min = Integer.MAX_VALUE;
	static ArrayList<node> chick = new ArrayList<>();
	static ArrayList<node> home = new ArrayList<>();
	static boolean[] visit;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		city = new int[N][N];
		
		for(int i = 0; i<N; i++)//ÃÊ±âÈ­
		{
			tk = new StringTokenizer(br.readLine(), " ");
			for(int j  = 0; j<N; j++)
			{
				city[i][j] = Integer.parseInt(tk.nextToken());
				if(city[i][j] == 1)
					home.add(new node(i,j));
				else if(city[i][j] == 2)
					chick.add(new node(i,j));
			}
		}
		H = home.size();
		C = chick.size();
		visit = new boolean[chick.size()];
		backtracking(0, 0);
		System.out.print(min);
		
	}
	public static void backtracking(int cnt, int idx) {
		if(cnt == M) {
			int total = 0;
			for(int i = 0; i<H; i++) {
				int sum = Integer.MAX_VALUE;
				for(int j = 0; j < C; j++) {
					if(visit[j]) {
						int dist = Math.abs(home.get(i).x - chick.get(i).x) 
								+ Math.abs(home.get(i).y - chick.get(i).y);
						sum = Math.min(sum, dist);
					}
				}
				total += sum;
			}
			min = Math.min(total, min);
			return;
		}
		for(int i = idx; i<C; i++) {
			if(!visit[i]) {
				visit[i] = true;
				backtracking(cnt+1, i+1);
				visit[i] = false;
			}
		}
	}
	
	
	public static class node{
		int x;
		int y;
		
		public node(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
}
