import java.io.*;
import java.util.*;

//26217 별꽃의 세레나데(easy)
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		double sum = 0;
		for(int i = 1; i<=N; i++) {
			sum += (double)N/(double)i;
		}
		System.out.print(sum);
	}
}
