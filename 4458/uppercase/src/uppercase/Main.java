package uppercase;

import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i= 0; i<N; i++)
		{
			String s = br.readLine();
			
			char first = s.charAt(0);
			if('a'<= first && first <= 'z')
				first = (char) (first - 32);
			sb.append(first + s.substring(1) + "\n");
		}
		System.out.println(sb);
	}
}
