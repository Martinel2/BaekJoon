import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Slength {

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		String S = reader.readLine();
		int len = S.length();
		System.out.println(len);
	}
}
