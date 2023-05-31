import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] UCPC = {'U', 'C', 'P', 'C'};
		String s = br.readLine();
		int len = s.length();
		
		int find = 0;
		
		for(int i = 0; i<len; i++) {
			if(UCPC[find] == s.charAt(i)) {
				find++;
				if(find >= UCPC.length)
					break;
			}
		}
		
		String ans = (find >= UCPC.length) ?  "I love UCPC" : "I hate UCPC" ; 
		
		System.out.println(ans);
	}
}
