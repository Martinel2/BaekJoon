import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		long N = Long.parseLong(br.readLine());
		
		String ans = N%2 == 0 ? "CY" : "SK";
		System.out.println(ans);
	}
}
