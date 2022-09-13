import java.io.*;
import java.util.*;

//15649 N°úM(3)
public class Main {
	
	static int N,M;
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void print(int cnt) {
		
		if(cnt == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i<N; i++)
		{
				arr[cnt] = i+1;
				print(cnt+1);
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
		
		print(0);
		
		System.out.println(sb);
		
	}
	
}
