import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long reverse(long k) {
		String num = String.valueOf(k);
		String rev = "";
		for(int i = 0; i<num.length(); i++) {
			rev += 9 - (num.charAt(i) - '0');
		}
		return k * Long.parseLong(rev);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			long n = Long.parseLong(br.readLine());
			
			for(long i = 10; true; i*=10) {
				if(n < i) {
					if(n < i/2) sb.append(reverse(n)).append('\n');
					else sb.append(reverse(i/2)).append('\n');
					break;
				}
			}
		}
		
		System.out.print(sb);
	}
}
