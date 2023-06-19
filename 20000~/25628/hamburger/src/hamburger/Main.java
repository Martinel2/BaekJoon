package hamburger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int bread = Integer.parseInt(st.nextToken());
		int pett = Integer.parseInt(st.nextToken());
		
		int pos = Math.min(bread/2, pett);
		
		System.out.println(pos);
	}
}
