package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean fold(String s, int l, int r) {
		if(l>=r) return true;
		
		int left = l;
		int right = r;
		while(left < right) {
			if(s.charAt(left) == s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return fold(s, l, right-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//���ڿ� ���̴� �׻� Ȧ��
		//�ٱ��ʺ��� ���ֺ��� 2���� ���̸� �������� ���� ���� �ݴ�� ����(�Ӹ�����̸� �ȵȴ�)
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			String s = br.readLine();
			
			int left = 0;
			int right = s.length()-1;
			
			String ans = fold(s,left,right)? "YES\n":"NO\n";
			sb.append(ans);
		}
		System.out.println(sb);
	}
}