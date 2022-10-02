import java.io.*;
import java.util.*;

//15649 N°úM(8)
public class Main {
	
	static int N,M;
	public static int[] arr;
	public static int[] numarr;
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
		
		for(int i = 0; i<N; i++)
		{
				if(k>numarr[i] || visit[i])
					continue;
				int sum = numarr[i];
				arr[cnt] = sum;
				visit[i] = true;
				print(cnt+1, sum);
				visit[i] = false;
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		numarr = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i= 0; i<N; i++)
			numarr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(numarr);
		print(0,numarr[0]);
		
		System.out.println(sb);
		
	}
	
}
