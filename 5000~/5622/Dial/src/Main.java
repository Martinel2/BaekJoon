import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		char[] s = br.readLine().toCharArray();
		
		for(int i = 0; i<s.length; i++)
		{
			char alpa = s[i];
			if(65<= alpa && alpa < 68)//2 
				sum += 3;
			else if(68<= alpa && alpa < 71)//3 
				sum += 4;
			else if(71<= alpa && alpa < 74)//4 
				sum += 5;
			else if(74<= alpa && alpa < 77)//5 
				sum += 6;
			else if(77<= alpa && alpa < 80)//6 
				sum += 7;
			else if(80<= alpa && alpa < 83)//7 
				sum += 8;
			else if(83<= alpa && alpa < 86)//8 
				sum += 9;
			else//9 
				sum += 10;
		}
		System.out.print(sum);
	}
}
