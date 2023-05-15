import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer S = new StringBuffer(br.readLine());
		StringBuffer T = new StringBuffer(br.readLine());
		
		while(S.length() != T.length()) {
			if(T.charAt(T.length()-1) == 'A') {
				T.deleteCharAt(T.length()-1);
			}
			else if(T.charAt(T.length()-1) == 'B'){
				T.deleteCharAt(T.length()-1);
				T.reverse();
			}
		}
		
		boolean enable = true;
		for(int i = 0; i<S.length(); i++) {
			if(S.charAt(i) != T.charAt(i)) {
				enable = false;
				break;
			}
		}
		if(enable)
			System.out.println("1");
		else System.out.println("0");
	}
}
