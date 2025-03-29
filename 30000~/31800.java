package solved;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] profit = new int[n];
		int[] pure = new int[n];
		
		int max = 0;
		int secMax = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			profit[i] = Integer.parseInt(st.nextToken());
			if(max < profit[i]) {
				secMax = max;
				max = profit[i];
			}
			else if(secMax <profit[i]) {
				secMax = profit[i];
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			int price = Integer.parseInt(st.nextToken());
			//순수익 = 이익 - (기회비용+가격)
			// = 이익 - ((자신을 제외한 가장 큰 이익-가격)+가격)
			// = 이익 - 자신을 제외한 가장 큰 이익
			if(max == profit[i]) {
				pure[i] = profit[i] - secMax;
			}else pure[i] = profit[i] - max;
			
			sb.append(pure[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}