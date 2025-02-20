package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
 
public class Main {		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		char c = br.readLine().charAt(0);
		String ans = "";
		
		if(c == 'M') ans = "MatKor";
		if(c == 'W') ans = "WiCys";
		if(c == 'C') ans = "CyKor";
		if(c == 'A') ans = "AlKor";
		if(c == '$') ans = "$clear";
		
		System.out.println(ans);
	}	
}