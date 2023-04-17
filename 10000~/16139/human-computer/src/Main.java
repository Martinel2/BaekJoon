import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int[][] sum = new int[s.length()][26];
		sum[0][s.charAt(0)-'a'] += 1;
		for(int i = 1; i<s.length(); i++) {
			sum[i][s.charAt(i)-'a'] += 1;
			for(int j = 0; j<26; j++) {
				sum[i][j] += sum[i-1][j];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			char alpa = st.nextToken().charAt(0);
			int str = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(str > 0)
				sb.append(sum[end][alpa-'a'] - sum[str-1][alpa-'a']).append("\n");
			else 
				sb.append(sum[end][alpa-'a']).append("\n");
		}
		System.out.println(sb);
	}
}
