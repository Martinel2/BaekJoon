import java.io.*;
import java.util.*;


//2357 최솟값과 최댓값
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++)//배열 초기화
			arr[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<M; i++)//M개의 쌍 계산
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			//0포함 안되어있으므로 -1해주기
			for(int j = a-1; j<b; j++)
			{
				if(max < arr[j] )
					max = arr[j];
				if(min > arr[j])
					min = arr[j];
			}
			sb.append(min + " " + max + "\n");
		}
		
		System.out.print(sb);
	}
}