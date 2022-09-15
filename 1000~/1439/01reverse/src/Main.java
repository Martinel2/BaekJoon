import java.io.*;
import java.util.*;


//1439 µÚÁý±â
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int slen = s.length();
		int cnt0 = 0;
		int cnt1 = 0;
		char[] arr = s.toCharArray();
		if(arr[0] == '1')
			cnt1++;
		else
			cnt0++;
		for(int i = 1; i<slen; i++)
		{
			if(arr[i-1] == '0' && arr[i] == '1')
				cnt1++;
			else if(arr[i-1] == '1' && arr[i] == '0')
				cnt0++;
			else
				continue;
		}
		System.out.print(Math.min(cnt0, cnt1));
	}
}