package cupholdedr;
import java.io.*;
import java.util.*;


//2810 дех╕╢У
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int holder = N;
		int couple = -1;
		for(int i = 0; i<N; i++)
		{
			if(s.charAt(i) == 'L')
			{
				couple += 1;
				i++;
			}
		}
		if(couple > 0)
			System.out.println(holder - couple);
		else
			System.out.println(holder);
	}
}