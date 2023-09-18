package walk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long x,y;
		long one,diag;
		long ans = 0;
		st = new StringTokenizer(br.readLine());
		
		x = Long.parseLong(st.nextToken());
		y = Long.parseLong(st.nextToken());
		one = Long.parseLong(st.nextToken());
		diag = Long.parseLong(st.nextToken());
		
		long c1,c2,c3;
		
		c1 = (x+y) * one; //한칸씩 모두 이동
		c2 = 0;
		if((x+y) % 2  == 0) //대각선으로 두칸씩 이동 ex) (0,0) -> (1,1) -> (2,0)
			c2 = Math.max(x, y) * diag;
		else
			c2 = (Math.max(x,y)-1)*diag + one;
		
		c3 = Math.min(x,y) * diag + Math.abs((x-y))*one; //대각선으로 이동후 나머지 한칸씩이동
		
		ans = Math.min(c1, Math.min(c2, c3));
		System.out.println(ans);
	}
}
