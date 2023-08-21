package ring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String roon = br.readLine();
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 0; i<N; i++) {
			String ring = br.readLine();
			
			for(int j = 0; j<10; j++) {
				boolean r = false;
				for(int k = 0; k<roon.length(); k++) {
					if(ring.charAt(((j+k)%10)) != roon.charAt(k))
						break;
					if(k == roon.length()-1) {
						r = true;
						cnt+=1;
					}
				}
				if(r)
					break;
			}
		}
		
		System.out.println(cnt);
	}
}
