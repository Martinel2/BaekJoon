package value;

import java.util.*;


public class value {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		
		String val; // �Է��� ���� ����
		int cnt = 0;// ����� ����
		val = input.nextLine();
		
		String[] parse = val.split(" "); // ���ڿ��� ���� �� ����
		int len = parse.length;
		for(int i = 0; i<len; i++) {
			if(Integer.valueOf(parse[i]) > 0) // ������ ��ȯ�Ͽ� ��
				cnt++;
		}
		System.out.println(cnt); //���
	}
}
