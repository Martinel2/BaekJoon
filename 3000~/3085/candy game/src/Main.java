import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//3085 사탕게임
public class Main {
	static int N, max; 
	static char[][] board;
	public static void cntCandy() {
		for (int i = 0; i < N; i++) {
			// 이전사탕 초기값
			char preCol = board[i][0];
			char preRow = board[0][i];
			// 세로cnt, 가로cnt
			int cntCol = 0, cntRow = 0;
			for (int j = 0; j < N; j++) {
				// (가로) 다음 사탕이 같다면 count 값 증가
				if(preCol == board[i][j])
					cntCol++;
				// (가로) 다음 사탕이 다르다면 count값 초기화 밑 사탕 정보 저장
				else {
					preCol = board[i][j];
					cntCol = 1;
				}
				// (세로) 다음 사탕이 같다면 count 값 증가
				if(preRow == board[j][i])
					cntRow++;
				// (세로) 다음 사탕이 다르다면 count값 초기화 밑 사탕 정보 저장
				else {
					preRow = board[j][i];
					cntRow = 1;
				}
				// 가로든 세로든 최대값 최신화
				max = Math.max(max, cntCol);
				max = Math.max(max, cntRow);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// NxN 크기의 보드
		N = Integer.parseInt(br.readLine());
		board = new char[N][];
		// 보드 값 입력
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		// 초기값
		max = Integer.MIN_VALUE;
		// 아무것도 하지 않았을때 먹을 수 있는 사탕 최대 개수
		cntCandy();
		// 하, 우
		int[] dRow = { 1, 0};
		int[] dCol = { 0, 1};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 아래쪽과 바꾼 경우, 오른쪽을 바꾼경우
				for (int index = 0; index < 2; index++) {
					int changeRow = i + dRow[index];
					int changeCol = j + dCol[index];
					// 범위를 벗어나면 continue
					if(changeRow < 0 || changeRow >= N || changeCol < 0 || changeCol >= N)
						continue;
					// 값을 변경하고 cntCandy() 실행
					char tmp = board[i][j];
					board[i][j] = board[changeRow][changeCol];
					board[changeRow][changeCol] = tmp;
					cntCandy();
					// 값 복구
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