import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			String s = br.readLine();
			int[] alpa = new int[26];
			boolean more = true;
			
			for(int i = 0; i<s.length(); i++) {
				int num = s.charAt(i)-'A';
				alpa[num]++;
				
				if(alpa[num] == 3) {
					alpa[num] = 0;
					if(i+1 < s.length() && num == s.charAt(i+1)-'A') {
						i++;
					}
					else {
						more = false;
						break;
					}
				}
			}
			
			if(more)
				sb.append("OK").append('\n');
			else
				sb.append("FAKE").append('\n');
		}
		
		System.out.println(sb);
	}
}
