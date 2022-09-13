import java.io.*;
import java.util.*;

//15649 N°úM(4)
public class Main {
	
	static int N,M;
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void print(int cnt,int k) {
		
		if(cnt == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i<=N; i++)
		{
				if(k>i)
					continue;
				int sum = i;
				arr[cnt] = sum; 
				print(cnt+1, sum);
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N];
		
		print(0,1);
		
		System.out.println(sb);
		
	}
	
}
