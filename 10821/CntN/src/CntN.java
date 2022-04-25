import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CntN {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] S = reader.readLine().split(",");
		System.out.println(S.length);
	}
	
}