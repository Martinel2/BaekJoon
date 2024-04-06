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
	        
	        // 숫자를 나눠가며 유진수인지 확인
	        for (int i = 1; i < len; i++) {
	            // 숫자를 두 부분으로 나눔
	            String firstPart = num.substring(0, i);
	            String secondPart = num.substring(i);
	            
	            // 두 부분의 자릿수 곱이 같으면 유진수이므로 true 반환
	            if (calculateProduct(firstPart) == calculateProduct(secondPart)) {
	                return true;
	            }
	        }
	        // 모든 경우를 확인했지만 유진수가 아닌 경우 false 반환
	        return false;
	    }
	    
	    // 숫자의 각 자릿수를 곱하여 결과 반환하는 함수
	    public static long calculateProduct(String num) {
	        long product = 1;
	        
	        // 각 자릿수를 곱함
	        for (int i = 0; i < num.length(); i++) {
	            int digit = Character.getNumericValue(num.charAt(i));
	            product *= digit;
	        }
	        // 곱한 결과 반환
	        return product;
	    }
}