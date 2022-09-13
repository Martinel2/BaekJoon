import java.io.*;
import java.util.*;


//2740 Çà·Ä°ö¼À
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//AÇà·Ä
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];
		for(int i = 0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<M; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		//BÇà·Ä
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] B = new int[M][K];
		for(int i = 0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<K; j++)
				B[i][j] = Integer.parseInt(st.nextToken());
		}
		//°ö¼À
		for(int i = 0; i<N; i++)
		{
			for(int j = 0; j<K; j++)
			{
				int sum = 0;
				for(int l = 0; l<M; l++)
					sum += A[i][l]*B[l][j];
				
				sb.append(sum + " ");//°¡·ÎÁÙºÎÅÍ ÀúÀå
			}
			sb.append("\n");//´ÙÀ½Çà 
		}
		System.out.print(sb);
	}
}