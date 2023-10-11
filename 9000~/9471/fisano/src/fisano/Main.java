package fisano;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int fisano(int num) {
		int cnt = 0;
		int f1 = 0;
		int f2 = 1;
		do {
			int tmp = f1;
			f1 = f2;
			f2 = (tmp + f1)% num;
			cnt++;
		} while(f1 != 0 || f2 != 1);
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int grade = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			int len = fisano(num);
			sb.append(grade).append(" ").append(len).append('\n');
		}
		
		System.out.println(sb);
	}
}
