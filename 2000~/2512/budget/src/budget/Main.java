package budget;
import java.io.*;
import java.util.*;


//5676 �����ڵ�
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		int[] req = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			req[i] = Integer.parseInt(st.nextToken());
			sum += req[i];
		}
		int total = Integer.parseInt(br.readLine());
		Arrays.sort(req);
		if(total >= sum)// �� �ټ� ������
			System.out.println(req[N-1]); // ���� ū ��
		else // ���Ѿ��� �����ؾ� �ϸ�
		{
			int min = total/N;
			int i = 0;
			while(req[i] <= min)
			{
				total -= req[i];
				i++;
			}
			System.out.println(total/(N-i));
		}
		
	}
}