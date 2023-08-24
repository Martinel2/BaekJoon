package pelindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++) {
			int k = Integer.parseInt(br.readLine());
			String[] note = new String[k];
			
			for(int i = 0; i<k; i++) {
				note[i] = br.readLine();
			}
			
			boolean pelin = false;
			String str = "";
			
			for(int i = 0; i<k; i++) {
				for(int j = 0; j<k; j++) {
					if(i == j) continue;
					str = note[i] + note[j];
					int len = str.length();
					for(int m = 0; m<len/2; m++) {
						if(str.charAt(m) != str.charAt((len-1)-m))
							break;
						if(m == len/2 - 1)
							pelin = true;
					}
					if(pelin) break;
				}
				if(pelin) break;
			}
			if(pelin)
				sb.append(str).append('\n');
			else
				sb.append("0\n");
		}
		
		System.out.println(sb);
	}
}
