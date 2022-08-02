import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		A = A.replace('6', '5');
		B = B.replace('6', '5');
		int min = Integer.valueOf(A) + Integer.valueOf(B);
		
		A = A.replace('5', '6');
		B = B.replace('5', '6');
		int max = Integer.valueOf(A)+Integer.valueOf(B);
		
		System.out.print(min + " " + max);
		
		
		
		
	}
}
