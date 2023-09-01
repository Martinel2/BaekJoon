package num;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//숫자를 스트링에 대응해서 저장
	//스트링 배열을 정렬
	//스트링을 다시 숫자로 변경
	//10개씩 출력
	
	static int stringDigit(String digit) {
		switch(digit) {
		case "zero":
			return 0;
		case "one":
			return 1;
		case "two":
			return 2;
		case "three":
			return 3;
		case "four":
			return 4;
		case "five":
			return 5;
		case "six":
			return 6;
		case "seven":
			return 7;
		case "eight":
			return 8;
		case "nine":
			return 9;
		default:
			return 0;
		}
	}
	
	static String digitToString(int digit) {
		switch(digit) {
		case 0:
			return "zero";
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		default:
			return "";
		}
	}
	
	static int stringToInt(String s) {
		int num = 0;
		String[] strnum = s.split(" ");
		for(int i = 0; i<strnum.length; i++) {
			num += stringDigit(strnum[i]);
			if(i < strnum.length-1)
				num *= 10;
		}
		return num;
	}
	
	static String intToString(int num) {
		String s = "";
		
		if(num >= 10)
		{
			int ten = num/10;
			s += digitToString(ten) + " " + digitToString(num%10);
		}
		else
			s += digitToString(num);
		return s;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[end-start+1];
		for(int i = start; i<=end; i++) {
			arr[i - start] = intToString(i);
		}
		Arrays.sort(arr);
		
		//for(String val : arr)
			//System.out.println(val);
		
		int cnt = 0;
		for(String val : arr) {
			int num = stringToInt(val);
			sb.append(num).append(" ");
			cnt++;
			if(cnt == 10) {
				sb.append('\n');
				cnt = 0;
			}
		}
		System.out.println(sb);
	}
}
