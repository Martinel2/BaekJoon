import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class paper{
		int x,y;
		
		paper(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean[][] paper = new boolean[101][101];
		// �������� ��
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// ũ�Ⱑ 10�� ������
			for (int n = y; n < y+10; n++) {
				for (int m = x; m < x+10; m++) {
					paper[n][m] = true;
				}
			}
		}
		// �����¿�
		int result = 0;
		int[] dRow = {-1, 1, 0, 0};
		int[] dCol = { 0, 0,-1, 1};
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[i].length; j++) {
				// �����̰� ���Ե� ������ ���ؼ�
				if(paper[i][j] == true) {
					// �����¿�
					for (int index = 0; index < 4; index++) {
						int next_Row = i + dRow[index];
						int next_Col = j + dCol[index];
						if(paper[next_Row][next_Col] == false)
							result++;
						// ���� ������ ������ ��쵵 result++;
						else if(next_Row < 0 || next_Row >= 100 || next_Col < 0 || next_Col >= 100)
							result++;
					}
				}
			}
		}
		System.out.println(result);
	}
}
/*
4
3 7
5 2
15 7
13 14
*/