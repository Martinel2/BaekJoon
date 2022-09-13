package aeiou;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class aeiou {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String S = reader.readLine();
		
		int len = S.length();
		int cnt = 0;
		for(int i = 0; i<len; i++)
		{
			char w = S.charAt(i);
			if(w == 'a' || w == 'e' || w == 'o' || w == 'u' || w == 'i')
			{
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}