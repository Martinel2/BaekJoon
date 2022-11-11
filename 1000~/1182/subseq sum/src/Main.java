import java.io.*;
import java.util.*;


//1182 부분수열의 합
public class Main {
	static int[] arr;
	static int flag = 1;
	static int N,S;
	static int ans = 0;
	public static StringBuilder sb = new StringBuilder();
	
	public static void print(int cnt,int sum,int k) {
		
		if(cnt == flag) {
			if(sum == S) 
				ans++;
			return;
		}
		
		for(int i = k+1; i<N; i++)
		{
				sum += arr[i];
				if(sum <= S) {
					k = i;
					print(cnt+1, sum,k);
				}
				sum -= arr[i];
		}
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N= Integer.parseInt(st.nextToken());
		S= Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		while(flag < N){
			print(0,0,0);
			flag++;
		}
		System.out.println(ans);
	}
}