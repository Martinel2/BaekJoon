import java.io.*;
import java.util.*;


//15663 N��M9
public class Main {
	
	static int[] arr;
	static boolean[] visit;
	static int[] ans;
	static int[] be;
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	static void print(int cnt) {
		if(cnt == M){
			int k = 0;
			for(int i = 0; i<M; i++){
				if(be[i] == ans[i])
					k++;
			}
			if(k == M)
				return;
			for(int var : ans)
				sb.append(var).append(" ");
			sb.append("\n");
			for(int i = 0; i<M; i++)
				be[i] = ans[i];
			return;
		}
		
		for(int i = 0; i<N; i++)
		{
			if(visit[i] || ( (cnt == 0) && (i!=0) && (arr[i-1] == arr[i]) ) ) 
				continue;
			visit[i] = true;
			ans[cnt] = arr[i];
			print(cnt+1);
			visit[i] = false;
			
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine() , " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr= new int[N];
		visit = new boolean[N];
		ans = new int[M];
		be = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		print(0);
		System.out.println(sb);
	}
}