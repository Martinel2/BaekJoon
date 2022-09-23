import java.io.*;
import java.util.*;


//25579 ��Ʈ���� ǳ��
public class Main {
	
	//union-find
	static int[] parent;
	static long[] sum;
	static int[] len;
	static long s = 0;
	static void union(int a, int b)
	{
		a = find(a);
		b = find(b);
		if(a != b)
		{
			//�׻� �� �������� �θ�
			if(a > b)
			{
				//swap
				int temp = a;
				a = b; 
				b = temp;
			}
			s = s - (sum[a]*len[a])-(sum[b]*len[b]);
			parent[b] = a;
			len[a] += len[b];
			sum[a] += sum[b];
			s += (sum[a]*len[a]);
		}
	}
	
	static int find(int a)
	{
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]); //��� ����
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] balloon = new int[N+1];
		int[] order = new int[N+1];
		len = new int[N+1];
		sum = new long[N+1];
		parent = new int[N+1];
		long max = 0;
		st = new StringTokenizer(br.readLine(), " "); // ǳ�� ����
		for(int i  = 1; i<=N; i++)
			balloon[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " "); // ����
		for(int i = 1; i<=N; i++)
			order[i] = Integer.parseInt(st.nextToken());
		for(int i = N; i>1; i--)
		{
			//parent �� 0�̸� �����ִ°� - ���鼭 ���ϱ�
			int o = order[i];
			parent[o] = o;
			len[o]++;
			sum[o] += balloon[o];
			s += balloon[o];
			if(o > 1)
				if(parent[o-1] != 0)
					union(o-1, o);
			if(o < N)
				if(parent[o+1] != 0)
					union(o,o+1);
			if(max<s)
				max = s;
		}
		System.out.print(max);
 	}
}