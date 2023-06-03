import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//'A' = 65 'a' = 97 	97-65 = 32
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			String s  = br.readLine();
			int slen = s.length();
			String ans = "";
			for(int j = 0; j<slen; j++) {
				if(s.charAt(j) < 'a') {
					ans += (char)(s.charAt(j)+32);
				}
				else
					ans += s.charAt(j);
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
