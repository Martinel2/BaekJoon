package wolfAndSheep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] g = new char[R][C];
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int ans = 1;
		for(int i = 0; i<R; i++) {
			g[i] = br.readLine().toCharArray();
		}
		
		Loop: for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(g[i][j] == 'S') {
					for(int k = 0; k<4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if((0 <= x && x < R) && (0 <= y && y < C)) {
							if(g[x][y] == 'W') {
								ans = 0;
								break Loop;
							}
							else if(g[x][y] == '.') {
								g[x][y] = 'D';
							}
						}
					}
				}
			}
		}
		
		if(ans == 0)
			System.out.println(0);
		else {
			System.out.println(1);
			for(int i = 0; i<R; i++) {
				for(char c : g[i]) {
					System.out.print(c);
				}
				System.out.println();
			}
		}
	}
}
