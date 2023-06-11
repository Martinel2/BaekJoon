package club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		while(s.charAt(0) != '#') {
			String[] info = s.split(" ");
			
			int age = Integer.parseInt(info[1]);
			int weight = Integer.parseInt(info[2]);
			
			sb.append(info[0]);
			
			if(age > 17 || weight >= 80)
				sb.append(" Senior\n");
			else
				sb.append(" Junior\n");
			s = br.readLine();
		}
		System.out.println(sb);
	}
}

