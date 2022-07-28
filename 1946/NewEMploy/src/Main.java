import java.io.*;
import java. util.*;


class Grade implements Comparable<Grade>{
	int w;
	int s;
	
	Grade(int w, int s){
		this.s = s;
		this.w = w;
	}
	
	@Override
	public int compareTo(Grade o) {
		if(this.w > o.w)
			return 1;
		else
			return -1;
	}
}

public class Main {
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		
		for(int i = 0; i<T; i++)
		{
			int N = Integer.parseInt(br.readLine());
			ArrayList<Grade> G= new ArrayList<>(); 
			int cnt = 1;
			
			for(int j = 0; j<N; j++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				int w = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				G.add(new Grade(w,s));
				
			}
			Collections.sort(G);
			
			int min = G.get(0).s;
			
			for(int j = 1; j<N; j++)
			{
				if(G.get(j).s < min) {
					cnt++;
					min = G.get(j).s;
				}
			}
			
			System.out.println(cnt);
		}
	}
}
