package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//14226
public class Main {
	
	static class P{
		int clip;
		int s;
		int cnt;
		
		P(int s, int clip, int cnt){
			this.s = s;
			this.clip = clip;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] visit = new boolean[2001][2001];
		visit[1][0] = true;
		
		Queue<P> q = new LinkedList<>();
		
		q.add(new P(1,0,0));
		
		int ans = 0;
		while(!q.isEmpty()) {
			P p = q.poll();
			int len = p.s;
			int clip = p.clip;
			
			if(n == len) {
				ans = p.cnt;
				break;
			}
			//System.out.println(q.size());
			if(len > 0 && len<2001) {
				//클립보드에 저장
				if(!visit[len][len]) {
					visit[len][len] = true;
					q.add(new P(len,len,p.cnt+1));
				}
			}
			
			if(clip > 0 && len+clip < 2001) {
				//붙여넣기만 하는 경우
				if(!visit[len+clip][clip]) {
					visit[len+clip][clip] = true;
					q.add(new P(len+clip,clip,p.cnt+1));
				}
			}
			if(len > 0 && len<2001) {
				//하나를 삭제하는 경우
				if(!visit[len-1][clip]) {
					visit[len-1][clip] = true;
					q.add(new P(len-1,clip,p.cnt+1));
				}
			}
		}
		
		System.out.println(ans);
	}
}