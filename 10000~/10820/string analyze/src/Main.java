import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		while(s != null) {
			int[] cnt = new int[4];
			for(int i = 0; i<s.length(); i++) {
				int num  = s.charAt(i)-'0';
				int upper = s.charAt(i)-'A';
				int down = s.charAt(i)-'a';
				if(s.charAt(i) == ' ') 
					cnt[3]++;
				else if(0 <= num && num <= 9) 
					cnt[2]++;
				else if(0 <= upper && upper < 26)
					cnt[1]++;
				else if(0 <= down && down < 26)
					cnt[0]++;
			}
			sb.append(cnt[0]).append(" ").append(cnt[1]).append(" ").append(cnt[2]).append(" ").append(cnt[3]).append("\n");
			s = br.readLine();
		}
		System.out.println(sb);
	}
}
