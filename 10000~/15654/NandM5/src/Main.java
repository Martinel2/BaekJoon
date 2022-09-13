import java.io.*;
import java.util.*;

//15649 N과M(5)
public class Main {
	
	static int N,M;
	static int[] num;
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
			if(!visit[i]) {
				visit[i] = true;
				arr[cnt] = num[i];
				print(cnt+1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//배열 초기화
		num = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++)
		{
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		arr = new int[M];
		visit = new boolean[N];
		
		print(0);
		
		System.out.println(sb);
		
	}
	
}
