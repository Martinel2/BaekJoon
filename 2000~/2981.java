package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
 
public class Main {		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
 
		Arrays.sort(arr);	// 정렬
 
		int gcdVal = arr[1] - arr[0];	// 음수가 되지 않도록 큰 수에서 작은 수로 빼준다.
 
		for(int i = 2; i < N; i++) {
			// 직전의 최대 공약수와 다음 수(arr[i] - arr[i - 1])의 최대공약수를 갱신 
			gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]);
		}
 
		StringBuilder sb = new StringBuilder();
		
		// 최대공약수의 약수들 찾기 (절반까지만 탐색)
		for(int i = 2; i <= gcdVal / 2; i++) {
	    
			// i의 제곱 값이 최대공약수의 약수라면?
			if(gcdVal % i == 0) {
				sb.append(i + " ");
			}
		}
		
		// 마지막 최대공약수 꼭 출력해야함
		sb.append(gcdVal);
        
		System.out.println(sb);
		
	}
	
	// 최대공약수 함수
	static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
 
}