package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	
	static int[] arr = new int[10005];
	static StringBuilder sb = new StringBuilder();
	
	// ���� ��ȸ = �� �� ��
	// ���� ��ȸ = �� �� ��
	// ���� �˻� Ʈ���� ���ʿ� ������ �����ʿ� ū�Ŵ� ���� ��ȸ�� ū ���� ������ ��������Ʈ���� �Ǵ� ��
	static void post(int str, int end) {
		if(str>=end) return;
		
		int i;
		
		//���س�庸�� ũ�� ��������Ʈ���̹Ƿ� �����Ͽ� ���� �������� ����
		// ũ���ʴٸ� ������ ���� ���� ����Ʈ���� �������� ������ȸ ����
		for(i = str+1; i<end; i++)
			if(arr[str]<arr[i]) break;
			
		
		post(str+1,i);
		post(i, end);
		sb.append(arr[str]).append('\n');
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		
		int idx = 0;
		while((s=br.readLine()) != null) {
			arr[idx++] = Integer.parseInt(s);
		}
		
		post(0,idx);
		
		System.out.println(sb);
	}
}