package algorhythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//24479 �˰��� ���� - ���� �켱 Ž�� 1
public class Main {
	static int N; // ������ ����
	static int[][] arr; // �������
	static boolean[] visit; // �湮 ���� Ȯ��
	static int[] grade; // �湮 ���� ����
	
	//���� �켱 Ž��
	static void dfs(int idx, int cnt) {
		visit[idx] = true;
		grade[idx] = cnt;
		
		for(int i = 1; i<=N; i++) {
			if(!visit[i] && arr[idx][i] == 1)
				dfs(i, cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		grade = new int[N+1];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		dfs(R, 1);
		for(int i = 1; i <=N; i++) {
			System.out.println(grade[i]);
		}
	}
}

/*
5 5 1
1 4
1 2
2 3
2 4
3 4
*/
