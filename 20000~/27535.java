package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static class Choco implements Comparable<Choco>{
		char taste;
		int cnt;
		
		Choco(char taste, int cnt){
			this.taste = taste;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Choco o) {
			if(this.cnt == o.cnt) {
				return this.taste - o.taste;
			}
			return o.cnt - this.cnt;
		}
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		Choco[] box = new Choco[5];
		
		st = new StringTokenizer(br.readLine());
		box[0] = new Choco('H', Integer.parseInt(st.nextToken()));
		box[1] = new Choco('T', Integer.parseInt(st.nextToken()));
		box[2] = new Choco('C', Integer.parseInt(st.nextToken()));
		box[3] = new Choco('K', Integer.parseInt(st.nextToken()));
		box[4] = new Choco('G', Integer.parseInt(st.nextToken()));
		
		int eat = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<5; i++) sum += box[i].cnt;
		
		for(int i = 0; i<eat; i++) {
			int num = sum % 10;
			if(num == 0 || num == 1) num = 10;
			
			st = new StringTokenizer(br.readLine());
			//먹은 초콜릿 반영
			for(int j = 0; j<5; j++) {
				int ate = Integer.parseInt(st.nextToken());
				box[j].cnt -= ate;
				//System.out.println(box[j].cnt);
				sum -= ate;
			}
			
			//남은 초콜릿 갯수 진법으로 표현
			int rem = sum;
			String rems = "";
			if(rem == 0) rems += '0';
			while(rem > 0) {
				rems = Integer.toString(rem%num) + rems;
				rem = rem/num;
			}
			rems += "7H";
			
			sb.append(rems).append('\n');
			//종류별 남은 초콜릿 표현
			rems = "";
			if(sum == 0) rems = "NULL";
			else {
				Choco[] copy = Arrays.copyOf(box, 5);
				Arrays.sort(copy);
				for(int j = 0; j<5; j++) {
					if(copy[j].cnt != 0)
						rems += copy[j].taste;
				}
			}
			sb.append(rems).append('\n');
		}
		
		System.out.println(sb);
	}
}
