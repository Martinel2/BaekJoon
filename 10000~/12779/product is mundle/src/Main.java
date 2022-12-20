import java.io.*;
import java.util.*;

//12779 ªÛ«∞ is π∫µÈ 

public class Main {

	static long gcd(long a, long b)
	{
		if(b != 0)
			return gcd(b, a % b);
		else
			return a;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		long mom = b-a;
		long son = 0;
		
		for(long i = (long) Math.sqrt(a); i*i <=b; i++) {
			if(i*i>a)
				son++;
		}
		if(son == 0)
			System.out.println(0);
		else {
			long g = gcd(mom, son);
			System.out.print(son/g + "/" + mom/g);
		}
	}
}
