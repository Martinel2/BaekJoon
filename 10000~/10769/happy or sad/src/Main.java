import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(":-");
		int hl = 0, sl = 0;
		for(int i = 0; i<s.length; i++) {
			if(s[i].length() > 0 && s[i].charAt(0) == '(')
				sl++;
			else if(s[i].length() > 0 && s[i].charAt(0) == ')')
				hl++;
		}
		if(hl > sl)
			System.out.println("happy");
		else if(hl == sl && hl>0)
			System.out.println("unsure");
		else if(hl == 0 && sl == 0)
			System.out.println("none");
		else
			System.out.println("sad");
	}
}
