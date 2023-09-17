package sqrt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2417
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		long ans = (long)Math.sqrt(N);
		if(Math.pow(ans, 2) < N)
			ans += 1;
		System.out.println(ans);
	}
}
