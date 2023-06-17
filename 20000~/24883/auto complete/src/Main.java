import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//24883
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		
		String s = (n.equals("n") || n.equals("N")) ? "Naver D2":"Naver Whale";
		System.out.println(s);
	}
}
