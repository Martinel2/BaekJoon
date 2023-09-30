import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		while(input != null) {
			String s,t;
			st = new StringTokenizer(input);
			s = st.nextToken();
			t = st.nextToken();
			
			int idx = 0;
			for(int i = 0; i<t.length();  i++) {
				if(s.charAt(idx) == t.charAt(i)) {
					idx++;
					if(idx == s.length())
						break;
				}
			}
			String ans = idx==s.length() ? "Yes" : "No";
			sb.append(ans).append('\n');
			
			input = br.readLine();
		}
		
		System.out.println(sb);
	}
}
