import java.io.*;
import java.util.*;

//11728 배열 합치기
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		int[] B = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int a = 0;
		int b = 0;
		for(int i = 0; i<N+M; i++) {
			int num = A[a] >= B[b] ? B[b++]:A[a++];
			sb.append(num).append(" ");
			if(a==N)
			{
				for(int j = b; j<M; j++) {
					sb.append(B[j]).append(" ");
				}
				break;
			}
			else if(b==M)
			{
				for(int j = a; j<N; j++) {
					sb.append(A[j]).append(" ");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
