package tournament;
import java.io.*;
import java.util.*;


//1057 토너먼트
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		int cnt = 1;
		while(Math.ceil((a/2)) != Math.ceil((b/2)))
		{
			cnt++;
			a = (int)Math.ceil((a/2));
			b = (int)Math.ceil((b/2));
		}
			System.out.println(cnt);
	}
}