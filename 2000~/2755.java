package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
	
		double ans = 0;
		double grade = 0;
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String sub = st.nextToken();
			int g = Integer.parseInt(st.nextToken());
			String a = st.nextToken();
			char alpa = a.charAt(0);
			double sum = 0;
			
			switch(alpa) {
			case 'A':
				sum = 4;
				break;
			case 'B':
				sum = 3;
				break;
			case 'C':
				sum = 2;
				break;
			case 'D':
				sum = 1;
				break;
			case 'F':
				sum = 0;
				break;
			}
			if(alpa != 'F') {
				char p = a.charAt(1);
				if(p == '+') sum += 0.3;
				else if(p == '-') sum -= 0.3;
			}
			ans += sum*g;
			grade += g;
		}
		ans /= grade;
		System.out.printf("%.2f", ans);
	}
}