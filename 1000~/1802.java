package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean fold(String s, int l, int r) {
		if(l>=r) return true;
		
		int left = l;
		int right = r;
		while(left < right) {
			if(s.charAt(left) == s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return fold(s, l, right-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//문자열 길이는 항상 홀수
		//바깥쪽부터 마주보는 2쌍의 종이를 기준으로 둘은 서로 반대로 접힘(팰린드롬이면 안된다)
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			String s = br.readLine();
			
			int left = 0;
			int right = s.length()-1;
			
			String ans = fold(s,left,right)? "YES\n":"NO\n";
			sb.append(ans);
		}
		System.out.println(sb);
	}
}