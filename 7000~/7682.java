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
			//�������� �� ä������ ��
			//X�� ���� ���� ���������� O���� 1�� ������ ���ƾ� �Ѵ�.
			if(oCnt+xCnt==9 && xCnt-oCnt==1) {
				//�� ���� ���� �ϼ��ϸ� ������ ������ ������
                //�� �� ���� ������ �� ����.
				if(Check('X') && Check('O')) sb.append("invalid\n");
				//���� �� ä���� ��쿡�� O�� �̱� �� ����
				else if(Check('O')) sb.append("invalid\n");
				//X�� �̱� ���
				else sb.append("valid\n");
			}else{ //�������� �� ä������ ���� ���
				//���� �����ϰ� �� ���� ���� �Ǹ� 
                //�������ؼ� �� �� ������ ���� ����.
				if(Check('X') && Check('O')) sb.append("invalid\n");
				//X�� �̰��� ��, X�� �����̾ ������ O���� �ϳ� ���ƾ� �Ѵ�.
				else if(Check('X') && xCnt-oCnt==1) sb.append("valid\n");
				//O�� �̰��� ��, O�� �İ��̾ X�� O�� ũ�Ⱑ ���ƾ߸� �Ѵ�.
				else if(Check('O') && xCnt==oCnt) sb.append("valid\n");
				//�ƹ��� �̱��� �ʾҴµ� ���� �� ä������ �ʴ� ���� �Ұ����ϴ�.
				else sb.append("invalid\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static boolean Check(char tiktakto) {

		//���ΰ� ������ ��
		for(int i=0; i<3; i++) {
			int cnt = 0;
			for(int j=0; j<3; j++) {
				if(board[i][j]==tiktakto) cnt++;
			}
			if(cnt==3) return true;
		}
		//���η� ������ ��
		for(int j=0; j<3; j++) {
			int cnt = 0;
			for(int i=0; i<3; i++) {
				if(board[i][j]==tiktakto) cnt++;
			}
			if(cnt==3) return true;
		}
		//�밢������ ������ ��
		if(board[0][0]==tiktakto && board[1][1]==tiktakto 
        				&& board[2][2]==tiktakto) return true;
		if(board[0][2]==tiktakto && board[1][1]==tiktakto 
        				&& board[2][0]==tiktakto) return true;

		return false;
	}
}