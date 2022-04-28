package drow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class drow {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		
		
		String S = reader.readLine();
		while(!S.equals("END"))
		{
			StringBuffer re = new StringBuffer(S);
			st.append(re.reverse()+ "\n");
			S = reader.readLine();
		}
		System.out.println(st);
				
        
	}
}
