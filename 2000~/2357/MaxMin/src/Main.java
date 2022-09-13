import java.io.*;
import java.util.*;


//2357 �ּڰ��� �ִ�
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++)//�迭 �ʱ�ȭ
			arr[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<M; i++)//M���� �� ���
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			//0���� �ȵǾ������Ƿ� -1���ֱ�
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