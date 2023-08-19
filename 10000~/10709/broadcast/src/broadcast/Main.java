package broadcast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[][] sky = new int[H][W];
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				sky[i][j] = -1;
			}
		}
		
		for(int i = 0; i<H; i++) {
			String s = br.readLine();
			for(int j = 0; j<W; j++) {
				if(s.charAt(j) == 'c')
					sky[i][j] = 0;
				else if(j > 0 && sky[i][j-1] >= 0) {
					sky[i][j] = sky[i][j-1] + 1;
				}
			}
		}
		
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				System.out.print(sky[i][j] + " ");
			}
			System.out.println();
		}
	}
}
