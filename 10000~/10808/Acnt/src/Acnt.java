import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;

public class Acnt {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		String S = reader.readLine();
		
		int[] Alpa = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		int len = S.length();
		for(int i = 0; i<len; i++)
		{
			Alpa[S.charAt(i)-'a']++;
		}
		for(int i = 0; i<26; i++)
		{
			st.append(Alpa[i]+ " ");
		}
		System.out.println(st);
	}
        
}
