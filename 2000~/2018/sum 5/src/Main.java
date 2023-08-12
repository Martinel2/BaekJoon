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
		//자기자신도 연속된 수에 포함되기 때문에 무조건 하나는 존재함
		
		for(int i = 1; i < (n / 2) + 1; i++) {
			int sum = i;
			//연속된 수의 시작값은 i 부터 시작함
			for(int j = i + 1; i < (n / 2) + 2; j++) {
				if(sum == n) {
					count++;
					break;
				}
				//sum에 j를 계속 더해주면서 n과 같아지고 하나 count에 더해줌
				if(sum > n) {
					break;
				}
				//sum이 n보다 커지면 더이상 비교할 필요가 없기 때문에
				//break를 걸어줌
				sum += j;
			}
		}
		
		System.out.println(count);

		}
    	
    	
}