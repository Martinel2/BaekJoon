package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String T = br.readLine();
		String P = br.readLine();
		
		int Tlen = T.length();
		int Plen = P.length();
		int cnt = 0;
		int[] f = new int[Plen];
		int begin = 1, m = 0;

		// ������ Ȯ���Ѵ�.
		while(begin+m < Plen) {
		    // ��ġ�ϸ� m�� ������Ű�� �����Լ��� �ʱ�ȭ�Ѵ�.
		    if(P.charAt(begin+m)==P.charAt(m)) {
		        m++;
		        f[begin+m-1] = m;
		    }
		    else {
		        if(m==0)//���ۺ��� ����ġ
		           begin++;
		        else {//��ġ�ϴ� �κк��� �ٽ� ����
		           begin += (m - f[m-1]);
		           m = f[m-1];
		        }
		    }
		}
		begin = 0; m = 0;
		while(begin <= Tlen-Plen) {
			if(m<Plen && T.charAt(begin+m) == P.charAt(m)) {//��ġ�ϸ� m�� ����
				m++;
				
				if(m == Plen) {//������ġ�Ҷ�
					cnt++;
					sb.append(begin+1).append("\n");
				}
			}
			else {//����ġ�Ҷ�
				if(m==0)//���ۺ��� ����ġ
					begin++;
				else {//��ġ�ϴ� ���λ���� �ٽ� ����
					begin += m-f[m-1];
					m = f[m-1];
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb);
	}
}
