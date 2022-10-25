import java.io.*;
import java.util.*;


//11656 접미사 배열
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int slen = s.length();
		String[] arr = new String[slen];
		for(int i = 0; i<slen; i++)
			arr[i] = s.substring(i,slen);
		Arrays.sort(arr);
		for(String val : arr)
			System.out.println(val);
	}
}