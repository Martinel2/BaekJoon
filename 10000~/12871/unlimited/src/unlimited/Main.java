package unlimited;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		String ans = (a.contains(b) || b.contains(a)) ? "1" : "0";
		
		System.out.println(ans);
	}
}
