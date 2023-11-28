package card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] num = new int[10];
		boolean sameColor = true;
		char color = ' ';
		
		int maxNum = 0;
		int num1=0, idx1=0;
		int num2=0, idx2=0;
		int ans = 0;
		
		for(int i = 0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			
			char c = st.nextToken().charAt(0);
			int n = Integer.parseInt(st.nextToken());
			
			if(i == 0)
				color = c;
			else if(color != c)
				sameColor = false;
			
			num[n]++;
			
			if(num1 < num[n]) {
				if(idx1 != n) {
					num2 = num1;
					idx2 = idx1;
				}
				num1 = num[n];
				idx1 = n;
			}
			else if(num2 < num[n] && idx2 != idx1) {
				num2 = num[n];
				idx2 = n;
			}
			
			if(maxNum < n)
				maxNum = n;
		}
		
		int fst = idx1;
		int snd = idx2;
		
		boolean seq = true;
		int cnt = 0;
		if(num1 == 1) {
			for(int i = 1; i<10; i++) {
				if(cnt > 0) {
					if(num[i] != 1) {
						seq = false;
						break;
					}
					else
						cnt++;
					
					if(cnt == 5) {
						cnt = i;
						break;
					}
				}
				else {
					if(num[i] == 1)
						cnt++;
				}
			}
		}
		else
			seq = false;
		
		
		if(sameColor) {
			
			if(seq) {
				ans = cnt + 900;
			}
			else
				ans = maxNum + 600;
		}
		else {
			if(num1 == 4)
				ans = fst + 800;
			else if(num1 == 3 && num2 == 2)
				ans = fst*10 + snd + 700;
			else if(seq)
				ans = maxNum + 500;
			else if(num1 == 3)
				ans = fst + 400;
			else if(num1 == 2 && num2 == 2)
				ans = Math.max(fst,snd)*10 + Math.min(fst, snd) + 300;
			else if(num1 == 2)
				ans = fst + 200;
			else
				ans = maxNum + 100;
		}
		
		System.out.println(ans);
	}
}
