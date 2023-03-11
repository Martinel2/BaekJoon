import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int a1,a0;
		int c;
		int n0;
		
		st = new StringTokenizer(br.readLine());
		a1 = Integer.parseInt(st.nextToken());
		a0 = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(br.readLine());
		n0 = Integer.parseInt(br.readLine());
		
		if((a1*n0+a0) <= c*n0 )
			System.out.println(1);
		else
			System.out.println(0);
	}
}
