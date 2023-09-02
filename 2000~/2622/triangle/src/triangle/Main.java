package triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2 3 4 / 3 3 3 / 1 4 4
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		int n = Integer.parseInt(br.readLine());
		for(int a = 1; a<n; a++) {
			for(int b = a; b<n ;b++) {
				int c = n - (a+b); //c의길이는 남는 성냥갯수
				if(c < b) break;
				if(b+a > c) cnt++; //가장 긴변 < 두변길이합
			}
		}
		System.out.println(cnt);
	}
}
