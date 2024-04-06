package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		
		if (isEugeneNumber(n)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
		
	}
	
	 public static boolean isEugeneNumber(String num) {
	        int len = num.length();
	        
	        // ���ڸ� �������� ���������� Ȯ��
	        for (int i = 1; i < len; i++) {
	            // ���ڸ� �� �κ����� ����
	            String firstPart = num.substring(0, i);
	            String secondPart = num.substring(i);
	            
	            // �� �κ��� �ڸ��� ���� ������ �������̹Ƿ� true ��ȯ
	            if (calculateProduct(firstPart) == calculateProduct(secondPart)) {
	                return true;
	            }
	        }
	        // ��� ��츦 Ȯ�������� �������� �ƴ� ��� false ��ȯ
	        return false;
	    }
	    
	    // ������ �� �ڸ����� ���Ͽ� ��� ��ȯ�ϴ� �Լ�
	    public static long calculateProduct(String num) {
	        long product = 1;
	        
	        // �� �ڸ����� ����
	        for (int i = 0; i < num.length(); i++) {
	            int digit = Character.getNumericValue(num.charAt(i));
	            product *= digit;
	        }
	        // ���� ��� ��ȯ
	        return product;
	    }
}