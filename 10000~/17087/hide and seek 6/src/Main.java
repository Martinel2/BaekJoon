import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//17087
public class Main {
	
	static int gcd(int a , int b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] dis = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int d = Integer.parseInt(st.nextToken());
			dis[i] = Math.abs(d - S);
		}
		
		int ans = dis[0];
		for(int i = 1; i<N; i++) {
			ans = gcd(ans, dis[i]);
		}
		
		System.out.println(ans);
	}
}
