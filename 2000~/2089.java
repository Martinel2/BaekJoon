package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int d = Integer.parseInt(br.readLine());
		int nega = -2;
		String ans = "";
		
		if(d == 0)
			ans = "0";
		
		while(d != 0) {
			//System.out.println(d);
			int remainder = d%nega;
			d /= nega;
			if(remainder < 0) {
				remainder += 2;
				d++;
			}
			ans = String.valueOf(remainder) + ans;
			
		}
		
		System.out.println(ans);
	}
}