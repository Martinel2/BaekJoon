package triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2 3 4 / 3 3 3 / 1 4 4
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		int n = Integer.parseInt(br.readLine());
		for(int a = 1; a<n; a++) {
			for(int b = a; b<n ;b++) {
				int c = n - (a+b); //c�Ǳ��̴� ���� ���ɰ���
				if(c < b) break;
				if(b+a > c) cnt++; //���� �亯 < �κ�������
			}
		}
		System.out.println(cnt);
	}
}
