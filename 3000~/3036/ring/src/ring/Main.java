package ring;
import java.io.*;
import java.util.*;


//3036 링
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int F = Integer.parseInt(st.nextToken()); //첫번째 링
		for(int i = 1; i<N; i++)
		{
			int ring = Integer.parseInt(st.nextToken());
			int div = gcd(F,ring);
			sb.append(F/div).append("/").append(ring/div).append("\n");
		}
		System.out.print(sb);
	}
	
	static int gcd(int a, int b) {
		int r = a%b;
		if(r <= 1)
			return b;
		else
			return gcd(b,r);
	}
}