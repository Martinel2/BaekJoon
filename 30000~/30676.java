package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		String ans = "";
		
		if(num < 425) ans = "Violet";
		else if(num < 450) ans = "Indigo";
		else if(num < 495) ans = "Blue";
		else if(num < 570) ans = "Green";
		else if(num < 590) ans = "Yellow";
		else if(num < 620) ans = "Orange";
		else ans = "Red";
		
		System.out.println(ans);
		
    }
}