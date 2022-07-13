import java.io.*;
import java.util.*;



public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] lope = new int[n];
		for(int i = 0; i<n; i++)
		{
			lope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(lope);
		for(int i = 0; i<n; i++)
		{
			int k = n-i;
			int max = lope[i]*k;
			if(ans<max)
				ans = max;
		}
		System.out.print(ans);
	}
	static int ans = 0;
}
