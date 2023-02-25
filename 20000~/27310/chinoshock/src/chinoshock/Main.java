package chinoshock;
import java.io.*;
import java.util.*;

//27310 :chino-shock:
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int len = s.length();
		int clone = 0;
		int unbar = 0;
		
		for(int i = 0; i<len; i++)
		{
			if(s.charAt(i) == ':')
				clone++;
			else if(s.charAt(i) == '_')
				unbar++;
		}
		
		System.out.println(len+clone+(unbar*5));
	}
}