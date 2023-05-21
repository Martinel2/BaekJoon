package vote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int A = 0;
		int B = 0;
		String ans;
		for(int i = 0; i<V; i++) {
			if(s.charAt(i) == 'A')
				A++;
			else if(s.charAt(i) == 'B')
				B++;
		}
		if(A>B)
			ans = "A";
		else if(A<B)
			ans = "B";
		else
			ans = "Tie";
		System.out.println(ans);
	}
}
