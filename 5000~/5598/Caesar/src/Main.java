import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		for(int i = 0; i<s.length(); i++) {
			char si = s.charAt(i);
			if(si == 'A')
				sb.append('X');
			else if(si == 'B')
				sb.append('Y');
			else if(si == 'C')
				sb.append('Z');
			else
				sb.append((char)(s.charAt(i)-3));
		}
		System.out.println(sb);
	}
}
