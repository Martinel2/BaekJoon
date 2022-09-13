package value;

import java.util.*;


public class value {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		
		String val; // 입력을 받을 변수
		int cnt = 0;// 양수의 개수
		val = input.nextLine();
		
		String[] parse = val.split(" "); // 문자열로 받은 것 분할
		int len = parse.length;
		for(int i = 0; i<len; i++) {
			if(Integer.valueOf(parse[i]) > 0) // 정수로 변환하여 비교
				cnt++;
		}
		System.out.println(cnt); //출력
	}
}
