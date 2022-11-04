import java.io.*;
import java.util.*;


//11659 구간 합 구하기 4
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());//표의 크기
		int M = Integer.parseInt(st.nextToken());//합하는 횟수
		int[] S = new int[N+1];
		S[0] = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i<=N; i++)
		{
			int a = Integer.parseInt(st.nextToken());
			S[i]  = S[i-1] + a;
		}
		for(int i = 0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			sb.append(S[y1]-S[x1-1]).append("\n");
		}
		System.out.println(sb);
	}
}