import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(bf.readLine());		
		int count = 1;
		//�ڱ��ڽŵ� ���ӵ� ���� ���ԵǱ� ������ ������ �ϳ��� ������
		
		for(int i = 1; i < (n / 2) + 1; i++) {
			int sum = i;
			//���ӵ� ���� ���۰��� i ���� ������
			for(int j = i + 1; i < (n / 2) + 2; j++) {
				if(sum == n) {
					count++;
					break;
				}
				//sum�� j�� ��� �����ָ鼭 n�� �������� �ϳ� count�� ������
				if(sum > n) {
					break;
				}
				//sum�� n���� Ŀ���� ���̻� ���� �ʿ䰡 ���� ������
				//break�� �ɾ���
				sum += j;
			}
		}
		
		System.out.println(count);

		}
    	
    	
}