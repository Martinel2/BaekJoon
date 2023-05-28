import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			sb.append("Distances: ");
			st = new StringTokenizer(br.readLine());
			char[] s1 = st.nextToken().toCharArray();
			char[] s2 = st.nextToken().toCharArray();
			int len = s1.length;
			for(int j = 0; j<len; j++) {
				if(s1[j] <= s2[j])
					sb.append(s2[j]-s1[j]).append(" ");
				else
					sb.append((s2[j]+26) - s1[j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}
