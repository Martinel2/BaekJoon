package card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N,M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] card = new int[N][M];
		int[] cnt = new int[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				card[i][j] = Integer.parseInt(st.nextToken());
				if(card[i][j] > 0) cnt[i]++;
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			int min = 0;
			boolean[] color = new boolean[M];
			for(int j = 0; j<N; j++) {
				if(i==j || cnt[j] == 0)
					continue;
				else if(cnt[j] > 1) {
					min++;
				}
				else {
					int c=0;
					for(int k = 0; k<M; k++) {
						if(card[j][k] != 0) {
							c = k;
							break;
						}
					}
					if(color[c])
						min++;
					else
						color[c] = true;
				}
			}
			//System.out.println(min);
			ans = Math.min(ans, min);
		}
		
		System.out.println(ans);
	}
}

/*
11 12
0 2 0 0 0 8 0 0 0 0 7 0
0 0 0 0 0 4 0 0 0 0 0 0
0 6 0 0 0 0 6 0 0 0 0 0
0 0 6 0 0 0 0 0 0 3 6 2
0 0 0 7 2 0 0 0 0 0 0 0
0 0 0 0 4 0 0 0 0 0 0 0
0 0 4 0 0 9 0 0 3 0 0 0
0 0 0 8 0 0 0 0 0 0 0 0
0 2 0 0 3 0 0 0 3 0 0 0
0 0 0 5 0 0 2 0 0 0 0 0
0 0 0 0 0 0 3 0 0 0 0 0
*/
