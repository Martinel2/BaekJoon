import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//3085 ��������
public class Main {
	static int N, max; 
	static char[][] board;
	public static void cntCandy() {
		for (int i = 0; i < N; i++) {
			// �������� �ʱⰪ
			char preCol = board[i][0];
			char preRow = board[0][i];
			// ����cnt, ����cnt
			int cntCol = 0, cntRow = 0;
			for (int j = 0; j < N; j++) {
				// (����) ���� ������ ���ٸ� count �� ����
				if(preCol == board[i][j])
					cntCol++;
				// (����) ���� ������ �ٸ��ٸ� count�� �ʱ�ȭ �� ���� ���� ����
				else {
					preCol = board[i][j];
					cntCol = 1;
				}
				// (����) ���� ������ ���ٸ� count �� ����
				if(preRow == board[j][i])
					cntRow++;
				// (����) ���� ������ �ٸ��ٸ� count�� �ʱ�ȭ �� ���� ���� ����
				else {
					preRow = board[j][i];
					cntRow = 1;
				}
				// ���ε� ���ε� �ִ밪 �ֽ�ȭ
				max = Math.max(max, cntCol);
				max = Math.max(max, cntRow);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// NxN ũ���� ����
		N = Integer.parseInt(br.readLine());
		board = new char[N][];
		// ���� �� �Է�
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		// �ʱⰪ
		max = Integer.MIN_VALUE;
		// �ƹ��͵� ���� �ʾ����� ���� �� �ִ� ���� �ִ� ����
		cntCandy();
		// ��, ��
		int[] dRow = { 1, 0};
		int[] dCol = { 0, 1};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// �Ʒ��ʰ� �ٲ� ���, �������� �ٲ۰��
				for (int index = 0; index < 2; index++) {
					int changeRow = i + dRow[index];
					int changeCol = j + dCol[index];
					// ������ ����� continue
					if(changeRow < 0 || changeRow >= N || changeCol < 0 || changeCol >= N)
						continue;
					// ���� �����ϰ� cntCandy() ����
					char tmp = board[i][j];
					board[i][j] = board[changeRow][changeCol];
					board[changeRow][changeCol] = tmp;
					cntCandy();
					// �� ����
					tmp = board[i][j];
					board[i][j] = board[changeRow][changeCol];
					board[changeRow][changeCol] = tmp;
				}
			}
		}
		System.out.println(max);
		br.close();
	}
}