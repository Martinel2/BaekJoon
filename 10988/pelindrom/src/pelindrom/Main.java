package pelindrom;

import java.io.*;
import java.util.*;

//10988 �縰������� Ȯ���ϱ�
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String revers = "";
		int len = s.length();
		for(int i = len/2 -1; i>=0; i--)//������ ���������� ���� �ܾ �������� ���� �ܾ�� ����
			revers += (s.charAt(i));
		
		if(s.endsWith(revers))
			System.out.print("1");
		else
			System.out.print("0");
	}
}
