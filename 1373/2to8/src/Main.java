import java.io.*;
import java.util.*;


//1373 2진수 8진수
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String,String> convert = new HashMap<>();
		convert.put("000", "0");
		convert.put("001", "1");
		convert.put("010", "2");
		convert.put("011", "3");
		convert.put("100", "4");
		convert.put("101", "5");
		convert.put("110", "6");
		convert.put("111", "7");
		
		String bi = br.readLine();
		int blen = bi.length();
		if(blen % 3 ==0)
		{
			int i = 3;
			while(i <= blen)
			{
				sb.append(convert.get(bi.substring(i-3, i)));
				i += 3;
			}
		}
		else if(blen % 3 == 1)
		{
			String s = "00";
			s += bi.charAt(0);
			sb.append(convert.get(s));
			int i = 4;
			while(i <= blen)
			{
				sb.append(convert.get(bi.substring(i-3, i)));
				i += 3;
			}
		}
		else
		{
			String s = "0";
			s += bi.charAt(0);
			s += bi.charAt(1);
			sb.append(convert.get(s));
			int i = 5;
			while(i <= blen)
			{
				sb.append(convert.get(bi.substring(i-3, i)));
				i += 3;
			}
		}
		
		System.out.print(sb);
	}
}