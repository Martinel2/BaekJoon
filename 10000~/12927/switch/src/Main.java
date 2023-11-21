import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] b = br.readLine().toCharArray();
		
		int len = b.length;
		
		int cnt = 0;
		
		for(int i = 0; i<len; i++) {
			if(b[i] == 'Y') {
				cnt++;
				for(int j = 1; (i+1)*j<=len; j++) {
					int idx = ((i+1)*j) - 1;
					if(b[idx] == 'Y')
						b[idx] = 'N';
					else
						b[idx] = 'Y';
				}
			}
		}
		
		System.out.println(cnt);
	}
}
