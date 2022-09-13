import java.io.*;
import java.util.*;


public class PrimeDivide {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		boolean[] prime = new boolean[10000001];
		Arrays.fill(prime, true);
		for(int i = 2; i<=10000000; i++)
		{
			for(int j = 2; j*i<=10000000; j++)
			{
				prime[j*i] = false;
			}
		}
		int N = Integer.parseInt(br.readLine());
		while(N > 1) {
			for(int i = 2; i<=N; i++)
			{
				if(prime[i]==true && N%i == 0)
				{
					st.append(i + "\n");
					N = (int)N/i;
					break;
				}
			}
		}
		System.out.print(st);
	}
}
