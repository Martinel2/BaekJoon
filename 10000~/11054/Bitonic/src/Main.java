import java.io.*;
import java.util.*;

//11054 가장 긴 바이토닉 부분 수열
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] Idp = new int[N];
		int[] Ddp = new int[N];
		int max = 0;
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<N; i++)
		{
			A[i] = Integer.parseInt(tk.nextToken());
		}
		
		for(int i = 0; i<N; i++)
		{
			Idp[i] = 0;
			for(int j = i-1; j>=0; j--)
			{
				if(A[i] > A[j] && Idp[i] < Idp[j])
					Idp[i] = Idp[j];
			}
			Idp[i]++;	
		}
		
		for(int i = N-1; i>=0; i--)
		{
			Ddp[i]=0;
			for(int j = i+1; j<N; j++)
			{
				if(A[i]>A[j] && Ddp[i] < Ddp[j])
					Ddp[i] = Ddp[j];
			}
			Ddp[i]++;
		}
		
		for(int i = 0; i<N; i++)
		{
			int num = Idp[i] + Ddp[i];
			if(max < num)
				max = num;
		}
		System.out.print(max-1);
	}
}
