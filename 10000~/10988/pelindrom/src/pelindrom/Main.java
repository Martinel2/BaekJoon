package pelindrom;

import java.io.*;
import java.util.*;

//10988 펠린드롬인지 확인하기
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String revers = "";
		int len = s.length();
		for(int i = len/2 -1; i>=0; i--)//반으로 나누었을때 뒷쪽 단어가 뒤집으면 앞쪽 단어와 같음
			revers += (s.charAt(i));
		
		if(s.endsWith(revers))
			System.out.print("1");
		else
			System.out.print("0");
	}
}
