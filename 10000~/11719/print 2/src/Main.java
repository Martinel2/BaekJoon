import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		while(s!=null) {
			sb.append(s).append("\n");
			s = br.readLine();
		}
		System.out.println(sb);		
		
	}
}
