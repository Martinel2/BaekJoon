package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
 
	static int N, L;
	static int[][] map;
 
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		L = fr.nextInt();
 
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = fr.nextInt();
			}
		}
 
		int result = 0;
 
		// 가로 방향 체크
		for (int i = 0; i < N; i++) {
			if (canPass(map[i])) result++;
		}
 
		// 세로 방향 체크
		for (int i = 0; i < N; i++) {
			int[] col = new int[N];
			for (int j = 0; j < N; j++) {
				col[j] = map[j][i];
			}
			if (canPass(col)) result++;
		}
 
		System.out.println(result);
	}
 
	static boolean canPass(int[] line) {
		boolean[] built = new boolean[N];
 
		for (int i = 0; i < N - 1; i++) {
			if (line[i] == line[i + 1]) continue; // 높이 같으면 패스
 
			if (Math.abs(line[i] - line[i + 1]) > 1) return false; // 높이 차이가 1보다 크면 불가능
 
			if (line[i] > line[i + 1]) { // 내리막길 설치
				int height = line[i + 1];
				for (int j = i + 1; j <= i + L; j++) {
					if (j >= N || line[j] != height || built[j]) return false;
					built[j] = true;
				}
			} else { // 오르막길 설치
				int height = line[i];
				for (int j = i; j > i - L; j--) {
					if (j < 0 || line[j] != height || built[j]) return false;
					built[j] = true;
				}
			}
		}
		return true;
	}
}