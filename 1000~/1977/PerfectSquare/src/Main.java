import java.io.*;
import java.util.*;


//1977 ����������
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] ps = new boolean[10001]; // ���������� �Ǻ� �迭
		for(int i = 1; i*i<=10000; i++)
		{
			ps[i*i] = true;
		}
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = -1;
		for(int i = M; i<=N; i++)
		{
			if(ps[i])
			{	
				if(sum == 0)//���� ���� ������ ���� �ּڰ�
					min = i;
				sum += i;
			}
		}
		if(min == -1)
			System.out.print("-1");
		else
			System.out.print(sum + "\n" + min);
	}
}