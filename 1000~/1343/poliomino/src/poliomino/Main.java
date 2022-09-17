package poliomino;

import java.io.*;
import java.util.*;


//1343 폴리오미노
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String s = br.readLine();
		String ans =s.replaceAll("XXXX", "AAAA").replaceAll("XX", "BB");
		if(ans.contains("X"))
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}