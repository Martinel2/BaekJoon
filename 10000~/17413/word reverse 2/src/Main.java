import java.io.*;
import java.util.*;


//17413 �ܾ������ 2
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), "<");//<�������� ���ڿ� �ڸ���
		int l = st.countTokens();//�ڸ� ���ڿ��� ���� �ľ�
		if(l>1)//1�̻��̸� <>�� �����Ѵٴ� ��
		{
			for(int i = 0; i<l; i++)
			{
				String s = st.nextToken();
				int cnt = 0;
				sb.append("<");
				while(s.charAt(cnt) != '>')//�±� ó��
				{
					sb.append(s.charAt(cnt));
					cnt++;
				}
				sb.append(">");
				String temp = s.substring(cnt+1, s.length());//�±� ���� �κ��� ������
				String[] sbl = temp.split(" ");//����������� �ڸ���
				for(int j = 0; j<sbl.length; j++) {
					for(int k = sbl[j].length()-1; k>=0; k--)//�ܾ� ������
						sb.append(sbl[j].charAt(k));
					if(j<sbl.length-1)//�ܾ��� �������κ� = �±װ� �����ϴ� �κ��̹Ƿ� ����x
						sb.append(" ");
				}
			}
		}
		else// <>�� ������
		{
			String[] sbl = st.nextToken().split(" ");//����������� �ڸ���
			for(int i = 0; i<sbl.length; i++)
			{
				for(int j = sbl[i].length()-1; j>=0; j--)//�ܾ� ������
					sb.append(sbl[i].charAt(j));
				sb.append(" ");
			}
		}
		
		System.out.println(sb);
	}
}