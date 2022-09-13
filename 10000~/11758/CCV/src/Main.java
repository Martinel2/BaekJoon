import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] x = new long[3];
		long[] y = new long[3];
		for(int i = 0; i<3; i++)
		{
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			x[i] = Long.parseLong(tk.nextToken());
			y[i] = Long.parseLong(tk.nextToken());
		}
		//y = (y2-y1)/(x2-x1) *(x-x1) + y1    ==    (x2-x1)y = (y2-y1)*(x-x1) + (x2-x1)y1
		if(x[0] == x[1])//x�� ���� == ����(|)�϶�
		{
			if(y[0] < y[1]){//������ ȭ��ǥ. == x�� �������̸� �ð�
				if(x[2] > x[1])//��
				{
					System.out.print(-1);
				}
				else if( x[1] > x[2])//��
				{
					System.out.print(1);
				}
				else{
					System.out.print(0);
				}
					
			}
			else{ //�Ʒ����� ȭ��ǥ. x�� �����̸� �ð�
				if(x[2] < x[1])//��
				{
					System.out.print(-1);
				}
				else if( x[1] < x[2])//��
				{
					System.out.print(1);
				}
				else{
					System.out.print(0);
				}
			}
		}
		else 
		{
			long k = (x[1] - x[0]);
			long f = (y[1]-y[0])*(x[2]-x[0]) + k*y[0];
			if(x[0] < x[1]) {// �����ʹ��� ȭ��ǥ. �ð�������� ������ ���ʿ� (x[2],y[2])�� ����
				if( f > k*y[2])//�ð�
				{
					System.out.print(-1);
				}
				else if( f < k*y[2])//�ݽð�
				{
					System.out.print(1);
				}
				else{
					System.out.print(0);
				}
			}
			else if(x[0] > x[1])//���ʹ��� ȭ��ǥ. �ð�������� ������ ���ʿ� (x[2],y[2])�� ����
			{
				if( f < k*y[2])//�ð�
				{
					System.out.print(-1);
				}
				else if( f > k*y[2])//�ݽð�
				{
					System.out.print(1);
				}
				else{
					System.out.print(0);
				}
			}
		}
	}
}
