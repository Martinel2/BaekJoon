package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static ArrayList<String> sr = new ArrayList<>();
	static void cal(int idx, int dst, String ans) {
		//공백이 있는 경우를 처리해야함
		//일단 string을 구성하고, 마지막에 모든 연산을 처리
		
		if(idx > dst) {
			//스택으로 풀이
			String a = ans;
			a = a.replaceAll(" ", "");
			String n = a;
			n = n.replaceAll("[+,-]", " ");
			String[] num = n.split(" ");
			String o = a;
			o = o.replaceAll("[1-9]", "");
			
			int sum = Integer.parseInt(num[0]);
			for(int i = 1; i<num.length; i++) {
				char op = o.charAt(i-1);
				if(op == '+') sum += Integer.parseInt(num[i]);
				else sum -= Integer.parseInt(num[i]);
			}
			//System.out.println(n + " = " +sum + " " + o);
			if(sum == 0) sr.add(ans);
			return;
		}
		else {
			//+
			cal(idx+1,dst,ans+"+"+String.valueOf(idx));
			
			//-
			cal(idx+1,dst,ans+"-"+String.valueOf(idx));
			
			//blank
			cal(idx+1,dst,ans+" "+String.valueOf(idx));
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			sr.clear();
			int num = Integer.parseInt(br.readLine());
			cal(2,num,"1");
			Collections.sort(sr);
			for(String ans : sr) sb.append(ans).append('\n');
			sb.append('\n');
		}
		System.out.println(sb);
	}
}