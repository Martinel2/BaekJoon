package pelindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			boolean equal = true;
			for (int j = i, index = 0; j < s.length(); j++, index++) {
				// 1���ڶ� �ٸ��� break;
				if(s.charAt(j) != s.charAt(s.length()-1-index)) {
					equal = false;
					break;
				}
			}
			// ���� �¿찡 ��ģ�ٸ� ���ο� ���ڿ� ũ�� ���� �� break;
			if(equal) {
				ans = s.length() + i;
				break;
			}
		}
		System.out.println(ans);
	}
}
