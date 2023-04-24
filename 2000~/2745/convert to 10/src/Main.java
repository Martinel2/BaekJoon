import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2745
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		
		int idx = N.length()-1;
		int ans = 0;
		
		for(int i = N.length()-1; i>=0; i--) {
			int num = N.charAt(i) - '0';
			if(num > 9) {
				num = N.charAt(i)- 'A' + 10;
			}
			ans += num*Math.pow(B, idx-i);
		}
		
		System.out.println(ans);
	}
}
