package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s.equals("end")) break;

			int xCnt = 0;
			int oCnt = 0;
			board = new char[3][3];
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					board[i][j] = s.charAt(3*i+j);

					if(board[i][j]=='X') xCnt++;
					else if(board[i][j]=='O') oCnt++;
				}
			}
			//게임판이 꽉 채워졌을 때
			//X가 먼저 말을 놓았음으로 O보다 1개 무조건 많아야 한다.
			if(oCnt+xCnt==9 && xCnt-oCnt==1) {
				//한 명이 빙고를 완성하면 게임이 끝나기 때문에
                //둘 다 빙고가 성립될 수 없다.
				if(Check('X') && Check('O')) sb.append("invalid\n");
				//말이 꽉 채워진 경우에는 O가 이길 수 없다
				else if(Check('O')) sb.append("invalid\n");
				//X가 이긴 경우
				else sb.append("valid\n");
			}else{ //게임판이 꽉 채워지지 않은 경우
				//위와 동일하게 한 명이 빙고가 되면 
                //끝나야해서 둘 다 빙고인 경우는 없다.
				if(Check('X') && Check('O')) sb.append("invalid\n");
				//X가 이겼을 땐, X가 선공이어서 무조건 O보다 하나 많아야 한다.
				else if(Check('X') && xCnt-oCnt==1) sb.append("valid\n");
				//O가 이겼을 땐, O가 후공이어서 X와 O의 크기가 같아야만 한다.
				else if(Check('O') && xCnt==oCnt) sb.append("valid\n");
				//아무도 이기지 않았는데 말이 다 채워지지 않는 경우는 불가능하다.
				else sb.append("invalid\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static boolean Check(char tiktakto) {

		//가로가 성립할 때
		for(int i=0; i<3; i++) {
			int cnt = 0;
			for(int j=0; j<3; j++) {
				if(board[i][j]==tiktakto) cnt++;
			}
			if(cnt==3) return true;
		}
		//세로로 성립할 때
		for(int j=0; j<3; j++) {
			int cnt = 0;
			for(int i=0; i<3; i++) {
				if(board[i][j]==tiktakto) cnt++;
			}
			if(cnt==3) return true;
		}
		//대각선으로 성립할 때
		if(board[0][0]==tiktakto && board[1][1]==tiktakto 
        				&& board[2][2]==tiktakto) return true;
		if(board[0][2]==tiktakto && board[1][1]==tiktakto 
        				&& board[2][0]==tiktakto) return true;

		return false;
	}
}