package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	
	 
	
	public static void main(String[] args) throws IOException { 
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test_case = Integer.parseInt(br.readLine());
		char[][] meat;
		for(int i=0; i<test_case; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			meat = new char[H][W];
			
			
			for(int j=0; j<H; j++) {
				String in = br.readLine();
				meat[j] = in.toCharArray();
			}
			
			for(int j=H-1 ; j>=0; j--) {
				System.out.println(meat[j]);
			}
			
		}
		
	}

}