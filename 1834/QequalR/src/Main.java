import java.io.*;
import java.util.*;


//1834 나머지와 몫이 같은 수
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long sum = 0;
		
		for(int i = 1; i<N; i++)
			sum+= (i*N + i);
		
		System.out.print(sum);
		
	}
}