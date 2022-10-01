import java.io.*;
import java.util.*;

//10972 다음순열
public class Main {
	
	static int N;
	public static int[] arr;
	public static boolean[] visit;
	public static String s;
	public static boolean flag1 = false;
	public static boolean flag2 = false;
	public static void print(int cnt) {
		
		if(flag2)
			return;
		
		if(cnt == N) {
			String as = "";
			for(int val : arr) {
				if(val == arr[N-1])
					as += val;
				else
					as += (val + " ");
			}
			if(flag1) {
				System.out.print(as);
				flag2 = true;
			}
			if(s.equals(as)) 
				flag1 = true;
			return;
		}
		
		for(int i = 0; i<N; i++)
		{
			if(flag2)
				return;
			
			if(!visit[i]) {
				arr[cnt] = i+1;
				visit[i] = true;
				print(cnt+1);
				visit[i] = false;
			}
		
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = br.readLine();
		arr = new int[N];
		visit = new boolean[N];
		
		print(0);
		if(!flag2)
			System.out.print(-1);
	}
	
}
