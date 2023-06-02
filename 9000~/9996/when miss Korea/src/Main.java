import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int f = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), "*");
		String left = st.nextToken();
		String right = st.nextToken();
		int lenL = left.length();
		int lenR = right.length();
		for(int i = 0; i<f; i++) {
			String s = br.readLine();
			if(s.length() < lenL + lenR) {
				sb.append("NE\n");
				continue;
			}
			else {
				if(!left.equals(s.substring(0, lenL))) {
					sb.append("NE\n");
					continue;
				}
				if(!right.equals(s.substring(s.length()-lenR, s.length()))) {
					sb.append("NE\n");
					continue;
				}
				sb.append("DA\n");
			}
		}
		
		System.out.println(sb);
	}
}
