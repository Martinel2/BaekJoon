package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[] rick = {"Never gonna give you up", 
						"Never gonna let you down",
						"Never gonna run around and desert you",
						"Never gonna make you cry",
						"Never gonna say goodbye",
						"Never gonna tell a lie and hurt you",
						"Never gonna stop"};
		
		int n = Integer.parseInt(br.readLine());
		boolean crack = false;
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			int j = 0;
			for(j = 0; j<rick.length; j++)
				if(s.equals(rick[j])) break;
			if(j >= rick.length) crack = true;
		}
		
		String ans = crack? "Yes":"No";
		
		System.out.println(ans);
    }
}