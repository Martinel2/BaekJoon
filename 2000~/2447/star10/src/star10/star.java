package star10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
 
public class star {
	static char[][] arr;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
 
		arr = new char[N][N];
        
		star10(0, 0, N, false);
 
		for (int i = 0; i < N; i++) {
			bw.write(arr[i]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
 
	static void star10(int x, int y, int N, boolean blank) {
 
		// ����ĭ�� ���
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
 
		// ���̻� �ɰ� �� ���� ����� ��
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}
 
		/*
		   N=27 �� ��� �� ����� ������� 9�̰�, 
		   N=9 �� ��� �� ����� ������� 3�̵�
		   �ش� ����� �� ĭ�� ���� ������ �ǹ� size
           
		   count�� �� ��� ������ �ǹ�
		 */
 
		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) { // ���� ĭ�� ���
					star10(i, j, size, true);
				} else {
					star10(i, j, size, false);
				}
			}
		}
	}
}