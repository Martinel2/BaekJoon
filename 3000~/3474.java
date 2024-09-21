package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//2와5의 갯수 중 최소값이 답
		//2는 짝수이면 모두 가지고 있으니 5의 갯수가 더 작을 것
		//60 = 12*5  12개 + 5,10구간에서 각각 +1 = 14
		//100 = 20*5 20개 + 20/5=4개 = 24개
		//1024 = 204*5+4 204/5=40+4  40/5 = 8 8/5 =1
		//204+40+8+1 = 253
		int t = Integer.parseInt(br.readLine());
		while(t--> 0) {
			int n = Integer.parseInt(br.readLine());
			int ans = 0;
			while(n >= 5) {
				n /=5;
				ans += n;
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
}