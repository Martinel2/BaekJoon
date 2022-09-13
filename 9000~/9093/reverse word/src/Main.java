import java.io.*;
import java.util.*;


//9093 단어 뒤집기 
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++)
		{
			String[] s = br.readLine().split(" ");
			String re = "";
			for(int i =0; i<s.length; i++)
			{
				for(int j = s[i].length()-1; j>=0; j--)
				{
					re += s[i].charAt(j);
				}
				re += " ";
			}
			sb.append(re + "\n");
		}
		System.out.print(sb);
	}
}