package goldminsu;
import java.io.*;
import java.util.*;


//±Ý¹Î¼ö
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int i,j;
		for(i = N; i>=4; i--)
		{
			String s = String.valueOf(i);
			int slen = s.length();
			for(j = 0; j<slen; j++)
			{
				
				if(s.charAt(j) != '4' && s.charAt(j) != '7')
					break;
			}
			if(j == slen)
			{
				System.out.println(s);
				break;
			}
		}
		
	}
}