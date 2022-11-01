import java.io.*;
import java.util.*;


//9613 GCD гу
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			long sum = 0;
			for(int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i<n-1; i++)
			{
				for(int j = i+1; j<n; j++)
				{
					int num1 = arr[i];
					int num2 = arr[j];
					sum+= gcd(num1,num2);
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	static int gcd(int a, int b) {
		while(b != 0)
        {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
	}
}