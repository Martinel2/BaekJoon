import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long gcd(long a, long b) {
		if(b == 0)
			return a;
		else {
			long c = a%b;
			return gcd(b,c);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		long n,m;
		
		st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		if(n<m) {
			long tmp = n;
			n = m;
			m = tmp;
		}
		
		long ans = gcd(n,m);
		System.out.println(ans);
		for(long i = 0; i<ans; i++) {
			sb.append('1');
		}
		System.out.println(sb);
	}
}
