import java.io.*;
import java.util.*;


//10451 ���� ����Ŭ
public class Main {
	public static int cnt = 1;

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++)
		{
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] visit = new int[N];
			int cnt = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i<N; i++)//�׷��� ������� ����
			{
				int m = Integer.parseInt(st.nextToken())-1;
				arr[i]= m;
			}
			for(int i = 0; i<N; i++)
			{
				int a = i;
				if(visit[a] == 0)
				{
					cnt++;
					while(visit[a] == 0)
					{
						visit[a] = i+1;
						a = arr[a];
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}