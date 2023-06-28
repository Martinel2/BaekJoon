package ant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10158
public class Main {
	
	static int dr[] = {1,1,-1,-1};
	static int dc[] = {1,-1,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken()); //q�� �÷�
		int p = Integer.parseInt(st.nextToken()); //p�� �ο�
		int t = Integer.parseInt(br.readLine());
		int x = (q+t)%(2*W);
		int y = (p+t)%(2*H);
		
		x = W - Math.abs(W-x);
		y = H - Math.abs(H-y);
		
		System.out.println(x+" "+y);
	}

}