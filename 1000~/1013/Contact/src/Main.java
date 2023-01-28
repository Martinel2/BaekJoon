import java.io.*;
import java.util.*;

//1013 Contact
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String V = "(100+1+|01)+";
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			String s = br.readLine();
			if(s.matches(V))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}