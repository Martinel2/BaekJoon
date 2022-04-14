package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;


public class Nohomework {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		
		boolean[] student = new boolean[31];
		student[0] = true;
		for(int i =1; i<31; i++)
		{
			student[i] = false;
		}
		for(int i =0; i<28; i++)
		{
			int a = Integer.parseInt(reader.readLine());
			student[a] = true;
		}
		for(int i =0; i<31; i++)
		{
			if(student[i] == false)
				st.append(i + "\n");
		}
		System.out.println(st);
	}
}
