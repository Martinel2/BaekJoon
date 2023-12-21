package carrot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int x,y;
		
		st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y =  Integer.parseInt(st.nextToken());
		
		int ans = x+y+(Math.min(x, y)/10);
		
		System.out.println(ans);
	}
}
