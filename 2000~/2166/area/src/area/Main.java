package area;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class P{
		long x,y;
		P(long x, long y){
			this.x=x;
			this.y=y;
		}
	}
	
	static long sol(P p1, P p2, P p3) {
		return ((p1.x*p2.y) + (p2.x*p3.y) + (p3.x*p1.y)) -((p1.y*p2.x) + (p2.y*p3.x) + (p3.y*p1.x));
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		P[] mat = new P[N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			mat[i] = new P(x,y);
		}
		
		long result = 0;
		
		for(int i = 2; i<N; i++) {
			result += sol(mat[1],mat[i],mat[i+1]);
		}
		
		result = Math.abs(result);
		if(result % 2 == 0)
			System.out.println(result/2+".0");
		else
			System.out.println(result/2+".5");
	}
}
