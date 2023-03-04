import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/*
		 1���� N���� ��������ȣ ����
		 �ϳ��� ������ �μ��ؾ���
		 ���ӵ� K���� �������� �μ� 5+2K��ŭ�� ��ũ���
		 ��ũ�� �ִ��� ����
		 */
		
		int N,M;
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // �� ������ ��ȣ
		M = Integer.parseInt(st.nextToken()); // ������ ����
		int[] non = new int[N+1];
		int min = N+1;
		int max = 0;
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken()); // ������ ��ȣ
			non[num] = 1;
		}
		int mnn = N+1;
		int mxn = 0;
		for(int i = 1; i<=N; i++) {
			non[i] += non[i-1];
			if(non[i] == non[i-1]) { // ���� ������ �߰�
				if(mnn < mxn) { //�̹� ������ ����
					
					if(i-mxn-1 > 2) // 3�� �̻� ���̳��� ����
					{
						ans += 5 + 2*(mxn-mnn+1);
						mnn = i;
					}
					else { // 2�� �̳� ���̸� ���� ��ġ��
						mxn = i;
					}
				}
				else {
					if(mnn > i)
						mnn = i;
					if(mxn < i)
						mxn = i;
				}
			}
		}
		if(mnn < mxn) {
			ans += 5 + 2*(mxn-mnn+1);
		}
		System.out.println(ans);
	}
}
