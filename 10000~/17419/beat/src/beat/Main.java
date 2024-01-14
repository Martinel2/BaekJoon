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
		// K & A = B   (B = 가장 오른쪽의 1만 남기고 모두 0 인 비트집합)
		// K - B = ans(가장 오른쪽의 1을 0으로 바꾼 수)
		//if(ans == 0) , cnt = 1의 갯수
		
		int cnt = 0;
		for(int i = 0; i<n; i++) {
			if(bit[i] == '1')
				cnt++;
		}
		System.out.println(cnt);
	}
}
