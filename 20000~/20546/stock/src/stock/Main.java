package stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int m = Integer.parseInt(br.readLine());
		
		int bM = m;//돈
		int bS = 0;//주식 갯수
		
		int tM = m;//돈
		int tS = 0;//주식 갯수
		int up = 0;//오름 카운트
		int down = 0;//내림 카운트
		
		int befPrice = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=14; i++) {
			int price = Integer.parseInt(st.nextToken());
			
			if(i != 1) {
				if(befPrice < price){
					up++;
					down = 0;
				}
				else if(befPrice == price) {
					up = 0;
					down = 0;
				}
				else {
					down++;
					up = 0;
				}
				
				if(down >= 3) {
					while(price <= tM) {
						tS += 1;
						tM -= price;
					}
				}
				if(up == 3) {
					tM += price*tS;
					tS = 0;
				}
			}
			
			while(bM >= price) {
				bS += 1;
				bM -= price;
			}
			befPrice = price;
		}
		
		String ans;
		int bnp = bM + bS*befPrice;
		int timing = tM + tS*befPrice;
		
		if(bnp < timing)
			ans = "TIMING";
		else if(bnp == timing)
			ans = "SAMESAME";
		else
			ans = "BNP";
		
		System.out.println(ans);
	}
}

/*
100
10 20 23 34 55 30 22 19 12 45 23 44 34 38
 */