import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder(); 
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++)
		{
			cnt = 0;
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(tk.nextToken());
			int y1 = Integer.parseInt(tk.nextToken());
			int x2  = Integer.parseInt(tk.nextToken());
			int y2 = Integer.parseInt(tk.nextToken());
			int n = Integer.parseInt(br.readLine());
			planet P = new planet(0,0,0);
			
			for(int j =0; j<n; j++)
			{
				StringTokenizer tk2 = new StringTokenizer(br.readLine(), " ");
				P.x = Integer.parseInt(tk2.nextToken());
				P.y = Integer.parseInt(tk2.nextToken());
				P.r = Integer.parseInt(tk2.nextToken());
				//두점 사이 거리가 반지름보다 짧다 == 원 안에 존재 == 무조건 거쳐감
				//시작 점과의 거리
				double dis1 = Math.sqrt( Math.pow( Math.abs(P.x-x1), 2 ) + Math.pow( Math.abs(P.y-y1), 2 ) );  
				//도착 점과의 거리
				double dis2 = Math.sqrt( Math.pow( Math.abs(x2-P.x),2 ) + Math.pow( Math.abs(y2-P.y), 2 ) );
				if(dis1 <= P.r || dis2 <= P.r) {
					cnt++;
				}
			}
			st.append(cnt + "\n");
		}
		System.out.print(st);
	}
	static int cnt;
	static class planet{
		int x;
		int y;
		int r;
		
		
		planet(int x,int y, int r)
		{
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
}
