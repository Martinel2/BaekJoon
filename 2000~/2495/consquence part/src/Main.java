import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<3; i++) {
			String s = br.readLine();
			
			char idx = s.charAt(0);
			int cnt = 1;
			int max = 0;
			for(int j = 1; j<8; j++) {
				if(idx == s.charAt(j))
					cnt++;
				else {
					idx = s.charAt(j);
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
