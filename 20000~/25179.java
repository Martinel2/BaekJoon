package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 	public static void main(String arg[]) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 		long N = Long.parseLong(st.nextToken());
 		long M = Long.parseLong(st.nextToken());
 		long remain = (N-1) % (M+1);
 		if(remain == 0)
 			System.out.println("Can't win");
 		else
 			System.out.println("Can win");
 	}
}