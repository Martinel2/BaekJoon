import java.io.*;
import java.util.*;


//24416 알고리즘수업-피보나치수 1
public class Main {
	static int[] f;
	static int fib(int n)
	{
		if(n==1 || n==2)
			return 1;
		else
			return (fib(n-1) + fib(n-2));
	}
	/*
	static int fibonacci(int n) {
		f[1] = f[2] = 1;  1번
		for(int i = 3; i<n; i++) n-3번
		{
			f[i] = f[i-1] + f[i-2];
		}
		return f[n-1];
	}
	*/
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		f = new int[N];
		
		System.out.print(fib(N) + " " + (N-2) );
		
	}
}