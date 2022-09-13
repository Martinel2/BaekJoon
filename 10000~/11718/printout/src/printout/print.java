package printout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class print {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		String print = reader.readLine();
		while(print != null)
		{
			if(!print.isEmpty() && !print.startsWith(" ") && !print.endsWith(" ") && print.length()<=100)
				st.append(print + "\n");
			else
				break;
			print = reader.readLine();
		}
		System.out.println(st);
	}
}
