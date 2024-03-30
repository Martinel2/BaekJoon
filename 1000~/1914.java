package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	static void hanoi(int n, int str, int end, int sub) {
		if(n==1)
			sb.append(str).append(" ").append(end).append('\n');
		else {
			hanoi(n-1,str,sub,end);
			sb.append(str).append(" ").append(end).append('\n');
			hanoi(n-1,sub,end,str);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		BigInteger cnt = new BigInteger("2");
		cnt = cnt.pow(n);
		cnt = cnt.add(new BigInteger("-1"));
		System.out.println(cnt);
		if(n < 5) {
			hanoi(n,1,3,2);
			System.out.println(sb);
		}
	}
}