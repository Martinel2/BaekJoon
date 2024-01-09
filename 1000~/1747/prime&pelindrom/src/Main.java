import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static boolean isPelindrom(String s) {
		int idx = 0;
		int len = s.length();
		for(int i = len-1; i>=0; i--) {
			if(s.charAt(i) == s.charAt(idx)) {
				idx++;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] che = new boolean[1003002];
		che[1] = true;
		
		for(int i = 2; i<1003002; i++) {
			if(!che[i]) {
				for(int j = 2; i*j<1003002; j++) {
					che[i*j] = true;
				}
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for(int i = N; i<1003002; i++) {
			if(!che[i]) {
				String s = String.valueOf(i);
				if(isPelindrom(s)) {
					ans = i;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
