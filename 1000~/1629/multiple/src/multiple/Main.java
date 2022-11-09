package multiple;
import java.io.*;
import java.util.*;


//1629 °ö¼À
public class Main {
	
	static long C;
	static long cut(long A, long B) {
		if(B == 1)
			return A%C;
		long sum = cut(A, B/2);
		
		if(B%2 == 1) {
			return (sum*sum % C) * A % C;
		}
		return sum * sum % C;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		System.out.print(cut(A,B));
	}
}