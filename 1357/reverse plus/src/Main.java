import java.io.*;
import java.util.*;


//1357 µÚÁýÈù µ¡¼À
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] num = br.readLine().split(" ");
		
		String rx = "";
		String ry = "";
		String ans = "";
		for(int i = num[0].length()-1; i>=0; i--)
			rx += num[0].charAt(i);
		for(int i = num[1].length()-1; i>=0; i--)
			ry += num[1].charAt(i);
			
		ans = String.valueOf(Integer.valueOf(rx) + Integer.valueOf(ry));
		for(int i = ans.length()-1; i>=0; i--)
			System.out.print(ans.charAt(i));
	}
}