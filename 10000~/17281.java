package solved;

import java.io.*;
import java.util.*;

public class Main {
	static int N, answer;
	static int[] order;
	static int[][] result;
	
	static void perm(int cnt, int visited) {
		if(cnt == 4) {
			perm(cnt + 1, visited); return;
		}
		
		if(cnt > 9) {
			play(); return;
		}
		
		for(int i = 1; i < 10; i++) {
			if((visited & (1 << i)) != 0) continue;
			order[cnt] = i;
			perm(cnt + 1, visited | (1 << i));
		}
	}
	
	static void play() {
		int start = 1, score = 0;
		for(int i = 0; i < N; i++) {
			int out = 0;
			int base = 0;
			while(out < 3) {
				if(start > 9) start = 1;
				
				base |= 1;
				int hit = result[i][order[start++]];
				if(hit == 0) {
					out++; continue;
				}
				
				for(int j = 3; j > 3 - hit; j--) if((base & (1 << j)) != 0) score++;
				base <<= hit;
			}
		}
		
		answer = Math.max(answer, score);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		result = new int[N][10];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < 10; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		order = new int[10];
		
		order[4] = 1;
		perm(1, 1 << 1);
		
		System.out.println(answer);
		br.close();
	}
}