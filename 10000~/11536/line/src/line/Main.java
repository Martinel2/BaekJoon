package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		String n1 = br.readLine();
		int incr = 0;
		int decr = 0;
		
		for(int i = 1; i<N; i++) {
			String name = br.readLine();
			if(n1.compareTo(name) < 0)
				incr++;
			else
				decr++;
		}
		
		if(decr != 0 && incr != 0)
			System.out.println("NEITHER");
		else if(decr != 0)
			System.out.println("DECREASING");
		else 
			System.out.println("INCREASING");
	}
}
