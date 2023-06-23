package bingo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2578
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] chl = new int[5][5];
		boolean[][] o = new boolean[5][5];
		int[][] call = new int[5][5];
		int cnt = 0;
		
		for(int i = 0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++) {
				chl[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++) {
				call[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Loop1 :for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				Loop2 :for(int m = 0; m<5; m++) {
					for(int n = 0; n<5; n++) {
						if(call[i][j] == chl[m][n]) {
							o[m][n] = true;
							cnt++;
							break Loop2;
						}
					}
				}
				
				//빙고 확인
				if(cnt >= 15) {
					int bingo = 0;
					for(int b = 0; b<5; b++) {
						
						//가로
						for(int r = 0; r<5; r++) {
							if(!o[b][r])
								break;
							if(o[b][r] && r == 4)
								bingo++;
						}
							
						
						//세로
						for(int r = 0; r<5; r++) {
							if(!o[r][b])
								break;
							if(o[r][b] && r == 4)
								bingo++;
						}
						
					}
					int x = 0;
					int y = 0;
					for(int b2 = 0; b2 < 5; b2++) {
						if(!o[x+b2][y+b2]) 
							break;
							
						if(o[x+b2][y+b2] && b2 == 4)
							bingo++;
					}
					
					x = 4;
					for(int b2 = 0; b2 < 5; b2++) {
						if(!o[x-b2][y+b2]) 
							break;
							
						if(o[x-b2][y+b2] && b2 == 4)
							bingo++;
					}
					if(bingo >= 3) {
						System.out.println(cnt);
						break Loop1;
					}
						
				}
			}
		}
	}
}
