package ant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//10158
public class Main {
	
	static int dr[] = {1,1,-1,-1};
	static int dc[] = {1,-1,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken()); //q가 컬럼
		int p = Integer.parseInt(st.nextToken()); //p가 로우
		int t = Integer.parseInt(br.readLine());
		int x = (q+t)%(2*W);
		int y = (p+t)%(2*H);
		
		x = W - Math.abs(W-x);
		y = H - Math.abs(H-y);
		
		sb.append(x).append(" ").append(y);
		bw.write(sb.toString());
		bw.close();
	}

}