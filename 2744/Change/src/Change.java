import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

//A: 65 a:97 97-65 = 32 
public class Change {

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		
		String S = reader.readLine();
		int len = S.length();
		for(int i = 0; i<len; i++)
		{
			char Alpa = S.charAt(i);
			if(Alpa >= 'a' && Alpa <= 'z')
				//97-32 = 65 = A
				st.append((char)(Alpa-32));
			else
				st.append((char)(Alpa+32));
		}
		System.out.println(st);
	}

}
