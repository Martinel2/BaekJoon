import java.io.*;
import java.util.*;


//1439  µÚÁý±â
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("1");
		int cnt0 = 0;
		int cnt1 = 0;
		String str = "";
		
		for(int i = 0; i<s.length; i++)
		{
			if(s[i].contains("0"))
				if(!str.contains("0"))
					cnt0++;
				else
					continue;
			else
				if(!str.contains("1"))
					cnt1++;
			str = s[i];
			
		}
		if(cnt0>cnt1)
			System.out.print(cnt1);
		else
			System.out.print(cnt0);
	}
}