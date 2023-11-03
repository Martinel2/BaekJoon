import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	// gcd(a,b) = gcd(b, a%b)
	static int gcd(int a, int b) {
		if(b == 0)
			return a;
		else
			return gcd(b,a%b);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			int len = st.countTokens();
			int[] arr = new int[len];
			
			
			for(int i = 0; i<len; i++) 
				arr[i] = Integer.parseInt(st.nextToken());			
			Arrays.sort(arr);
			
			int max = 0;
			for(int i = 0; i<len-1; i++) {
				for(int j = i+1; j<len; j++) {
					max = Math.max(max, gcd(arr[j],arr[i]));
				}
			}
			sb.append(max).append('\n');
		}
		
		System.out.println(sb);
	}
}
