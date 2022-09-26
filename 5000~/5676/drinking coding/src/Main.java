import java.io.*;
import java.util.*;


//5676 �����ڵ�
public class Main {
	static int N,K; // N: ���� ũ��  K: ���� ��
	static int nn;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s = br.readLine();
		while(s != null)
		{
			st = new StringTokenizer(s, " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			for (nn=1; nn<N; nn*=2);	// �ε�����Ʈ�� ũ�� Ư�� �� ����   (N���� ū �ּ� 2^N)
			arr = new char[nn*2+2];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i<=N; i++) {
				long num =  Long.parseLong(st.nextToken());
				if(num == 0)
					arr[nn+i-1] = '0';
				else if(num > 0)
					arr[nn+i-1] = '+';
				else
					arr[nn+i-1] = '-';
			}
			// ������ ������ �������			- �ؿ������� �����͸� �׾ƿø�
			for(int i=nn-1; i>=1; i--) {
				if(arr[i*2] == '0' || arr[i*2+1] == '0')
					arr[i] = '0';
				else if(arr[i*2] == '-' && arr[i*2+1] == '+' ||
						arr[i*2] == '+' && arr[i*2+1] == '-')
					arr[i] = '-';
				else
					arr[i] = '+';
			}
			for (int i=1; i<=K; i++) {
				String type;
				int x;
				long y;		
				st = new StringTokenizer(br.readLine());
				type = st.nextToken();		// 1�̸� edit, 2�̸� ����
				x = Integer.parseInt(st.nextToken());			// type=1 �ٲ� �� / type=2 startId
				y = Long.parseLong(st.nextToken());			// type=1 ���氪 / type=2 endId
			
				if (type.equals("C")) {
					edit(x,y);
				}
				else {
					int endId;
					endId = (int)y;
					sb.append(multi(x,endId));				
				}
			}
			sb.append("\n");
			s = br.readLine(); 
		}
		System.out.println(sb);
	}
	//�ε�����Ʈ�� �� ���ϱ� ���� �ö󰡸鼭 �� ���ϱ�
	static char multi(int start, int end) {
		int l = start + nn - 1;
		int r = end + nn - 1;
		char ret = '+';
		while(l<=r) {
			if ((l & 1) == 1) {
				if(ret == '0' || arr[l] == '0')
					return '0';
				else if(ret == '-' && arr[l] == '+' ||
						ret == '+' && arr[l] == '-')
					ret = '-';
				else
					ret = '+';
				l++;
			}	// ���� id�� Ȧ���̸� ���� Ƣ�Ƿ� �����ְ� l++ ���� (¦������ �����ؾ��ϴϱ�)
			if ((r & 1) == 0)// ������ id�� ¦���̸� ���� Ƣ�Ƿ� �����ְ� r-- ���� (Ȧ���� �������ϴϱ�)
			{
				if(ret == '0' || arr[r] == '0')
					return '0';
				else if(ret == '-' && arr[r] == '+' ||
						ret == '+' && arr[r] == '-')
					ret = '-';
				else
					ret = '+';
				r--;
			}
			l/=2;	// ���� �ö󰡱�
			r/=2;	// ���� �ö󰡱�
		}
		return ret;
	}
	// �ε�����Ʈ�� ���� 1) �ش� id �� ���� 2) ���� �ö󰡸鼭 �� ���� -> logN�� �ð����⵵
		static void edit(int id, long value) {
			int x = id + nn - 1;
			// �ε�����Ʈ�� ��ġ�� value�� ��ȣ ����
			if(value == 0)
				arr[x] = '0';
			else if(value > 0)	
				arr[x] = '+';
			else
				arr[x] = '-';
			x /= 2;
			while(x>0) {
				if(arr[x*2] == '0' || arr[x*2+1] == '0')
					arr[x] = '0';
				else if(arr[x*2] == '-' && arr[x*2+1] == '+' ||
						arr[x*2] == '+' && arr[x*2+1] == '-')
					arr[x] = '-';
				else
					arr[x] = '+';
				x /=2;
			}
			return;
		}
}