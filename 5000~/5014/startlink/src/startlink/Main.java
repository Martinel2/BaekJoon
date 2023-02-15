package startlink;
import java.io.*;
import java.util.*;

//5014 스타트링크
public class Main {
	
	static class stair{
		int cur = 0;
		int cnt = 0;
		
		stair(int cur, int cnt){
			this.cnt = cnt;
			this.cur = cur;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int Total, start, end, up, down;
		st = new StringTokenizer(br.readLine(), " ");
		Total = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		up = Integer.parseInt(st.nextToken());
		down = Integer.parseInt(st.nextToken());
		if(start == end)
			System.out.print(0);
		else {
			int[] SL;
			SL = new int[Total+1];
			Queue<stair> q = new LinkedList<>();
			q.add(new stair(start,0));
			while(!q.isEmpty()) {
				stair S = q.poll();
				int U = S.cur+up;
				int D = (S.cur-down);
				if(Total >= U && SL[U] == 0) {
					SL[U] = S.cnt+1;
					q.add(new stair(U,S.cnt+1));
				}
				if(0 < D && SL[D] == 0) {
					SL[D] = S.cnt+1;
					q.add(new stair(D,S.cnt+1));
				}
			}
			
			for(int val : SL)
				System.out.print(val+" ");
			
			if(SL[end] == 0)
				System.out.println("use the stairs");
			else
				System.out.println(SL[end]);
		}		
	}
}