package cmd;

import java.io.*;
import java.util.*;

//1032 명령프롬포트
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = "";
		char[] ans = new char[N];
		
		ans = br.readLine().toCharArray();
		for(int i = 0; i<N-1; i++)
		{
			s = br.readLine();
			for(int j = 0; j<s.length(); j++)
			{
				if(ans[j] != s.charAt(j) )
					ans[j] = '?';
			}
		}
		System.out.print(ans);
	}
}