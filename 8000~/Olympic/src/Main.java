import java.io.*;
import java.util.*;

// 8979 
public class Main {
	
	static class Nat implements Comparable<Nat>{
		int idx = 0;
		int gold = 0;
		int silver = 0;
		int bronze = 0;
		
		Nat(int idx, int gold, int silver, int bronze)
		{
			this.idx = idx;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		
		@Override
		public int compareTo(Nat o) {
			if(this.gold == o.gold)
			{
				if(this.silver == o.silver){
					return o.bronze - this.bronze; 
				}
				else
					return o.silver - this.silver;
			}
			else
				return o.gold - this.gold;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Nat[] Oly = new Nat[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			Oly[i] = new Nat(idx,gold,silver,bronze);
		}
		Arrays.sort(Oly);
		int cnt = 1;
		int nc = 1;
		if(Oly[0].idx == K)
			System.out.println(1);
		else {
			for(int i = 1; i<N; i++) {
				nc+=1;
				if(Oly[i-1].gold != Oly[i].gold 
						|| Oly[i-1].silver != Oly[i].silver
						|| Oly[i-1].bronze != Oly[i].bronze) {
					cnt = nc;
				}
				if(K == Oly[i].idx) {
					System.out.println(cnt);
					break;
				}
			}
		}
	}
}


/*
4 3
1 1 2 0
2 0 1 0
3 0 1 0
4 0 0 1
*/