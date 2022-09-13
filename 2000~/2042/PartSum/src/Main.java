import java.io.*;
import java.util.*;


//2042 ���� �� ���ϱ�
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());//���� ����
		int M = Integer.parseInt(st.nextToken());//����Ƚ��
		int K = Integer.parseInt(st.nextToken());//������Ƚ��
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++)//�迭 �ʱ�ȭ
			arr[i] = Integer.parseInt(br.readLine());
		
		while(M != 0 || K != 0)// Ƚ���� ���� �����Ҷ�����
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			long sum = 0;
			if(a == 1)//����
			{
				M--;
				arr[b-1] = c;
			}
			else//������ ���ϱ�
			{
				K--;
				for(int i = b-1; i<c; i++)
					sum += arr[i];
				sb.append(sum + "\n");
			}
		}
		System.out.print(sb);
	}
}