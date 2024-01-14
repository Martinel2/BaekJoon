package beat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		char[] bit = new char[n];
		
		bit = br.readLine().toCharArray();
		
		//K = K- ( K& ( ( ~K ) + 1 ) )
		// ~K + 1 = A 
		// K & A = B   (B = ���� �������� 1�� ����� ��� 0 �� ��Ʈ����)
		// K - B = ans(���� �������� 1�� 0���� �ٲ� ��)
		//if(ans == 0) , cnt = 1�� ����
		
		int cnt = 0;
		for(int i = 0; i<n; i++) {
			if(bit[i] == '1')
				cnt++;
		}
		System.out.println(cnt);
	}
}
