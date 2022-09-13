import java.util.*;
import java.io.*;
import java.math.*;

public class DSLR {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i =1; i<=T; i++) {
			boolean visit[] = new boolean[10001];
			Queue<Register> q = new LinkedList<>();
			String[] s = br.readLine().split(" ");	
			int A,B;
			A = Integer.parseInt(s[0]);
			B = Integer.parseInt(s[1]);
			visit[A] = true;
			q.add(new Register(A,""));
			while(!q.isEmpty()) {
				Register cur  = q.poll();
				
				if(cur.num == B)
				{
					st.append(cur.com + "\n");
					break;
				}
				if(!visit[cur.D()])
				{
					q.add(new Register(cur.D() , cur.com+"D"));
					visit[cur.D()] = true;
				}
				if(!visit[cur.S()])
				{
					q.add(new Register(cur.S() , cur.com+"S"));
					visit[cur.S()] = true;
				}
				if(!visit[cur.L()])
				{
					q.add(new Register(cur.L() , cur.com+"L"));
					visit[cur.L()] = true;
				}
				if(!visit[cur.R()])
				{
					q.add(new Register(cur.R() , cur.com+"R"));
					visit[cur.R()] = true;
				}
			}
			
		}
		System.out.print(st);
	} 
	static class Register{
		int num;
		String com;
		
		Register(int num, String com)
		{
			this.num = num;
			this.com = com;
		}
		
		int D(){
			return (num * 2) % 10000;
		}
		int S() {
			return num == 0 ? 9999 : num - 1;
		}
		int L() {
		     return num % 1000 * 10 + num / 1000;
		}
		int R() {
			return num % 10 * 1000 + num / 10;
		}
	}
}
