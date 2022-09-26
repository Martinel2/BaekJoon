package budget;
import java.io.*;
import java.util.*;


//2512 ����
public class Main {
	static int total;
	static int[] req;
	static boolean check(int mid)
	{
		int s = total;
		for(int i = 0; i<req.length; i++)
		{
			if(mid>req[i])
				s -= req[i];
			else
				s -= mid;
			if(s < 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		req = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			req[i] = Integer.parseInt(st.nextToken());
			sum += req[i];
		}
		total = Integer.parseInt(br.readLine());
		Arrays.sort(req);
		if(total >= sum)// �� �ټ� ������
			System.out.println(req[N-1]); // ���� ū ��
		else // ���Ѿ��� �����ؾ� �ϸ�
		{
			int min = total/N;
			int max = req[N-1];
			
			while(min +1 < max)
			{
				int mid = (max+min)/2;
				System.out.println(max + " "  +min);
				if(check(mid))
					min = mid;
				else
					max = mid;
			}
			System.out.println(min);
		}
		
	}
}