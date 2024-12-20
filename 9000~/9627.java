package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();
		int i, n = Integer.parseInt(br.readLine());
		for(i=0;i<n;i++) sb.append(br.readLine()+" ");
		String word = sb.toString().trim();
		bw.write(solve(word));
		
		bw.close();
		br.close();
	}
	
	private static String solve(String word) {
		String strNum;
		int i, len = word.replaceAll(" ", "").length() - 1;
		
		for(i=1;i<1000;i++)
			if((strNum = getStr(i)).length() + len == i)
				return word.replace("$", strNum);
		
		return word; //못 찾은 경우
	}
	
	private static String getStr(int num) {
		StringBuilder sb = new StringBuilder();
		
		/* 100 이상인 경우 우선 처리 */
		if(num >= 100) {
			sb.append(ONE[num/100]+"hundred");
			num %= 100;
		}
		
		/* 10 이상인 경우 & 10 미만인 경우 모두 처리 */
		if(20<=num) sb.append(TEN[1][num/10] + ONE[num%10]);
		else if(10<=num&&num<20) sb.append(TEN[0][num%10]);
		else sb.append(ONE[num]);
		
		return sb.toString();
	}
	
	private static final String ONE[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	private static final String TEN[][] = {
			{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"},
			{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"}
	};
}