package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	private static int N;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		// 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값
		dfs(clone(map), 0);
		System.out.println(max);
	}

	private static void dfs(int[][] arr, int cnt) {
		if (cnt != 0)
			findMax(arr);
		if (cnt == 5) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			dfs(arrange(arr, i), cnt + 1);
		}
	}

	private static int[][] arrange(int[][] arr, int dir) {
		int tmp[][] = clone(arr);
		switch (dir) {
		case 0: // 상
			for (int c = 0; c < N; c++) {
				int r = 0;
				while (r < N - 1) {
					int k = r + 1;
					while (k + 1 < N && tmp[k][c] == 0) {
						k++;
					}
					if (tmp[k][c] == 0) {
						r++;
						continue;
					}
					if (tmp[r][c] == 0) {
						tmp[r][c] = tmp[k][c];
						tmp[k][c] = 0;
						continue;
					} else if (tmp[r][c] == tmp[k][c]) {
						tmp[r][c] *= 2;
						tmp[k][c] = 0;
					} else if (tmp[r][c] != tmp[k][c] && k != r + 1) {
						tmp[r + 1][c] = tmp[k][c];
						tmp[k][c] = 0;
					}
					r++;
				}
			}
			break;
		case 1: // 하
			for (int c = 0; c < N; c++) {
				int r = N - 1;
				while (r > 0) {
					int k = r - 1;
					while (k - 1 > -1 && tmp[k][c] == 0) {
						k--;
					}
					if (tmp[k][c] == 0) {
						r--;
						continue;
					}
					if (tmp[r][c] == 0) {
						tmp[r][c] = tmp[k][c];
						tmp[k][c] = 0;
						continue;
					} else if (tmp[r][c] == tmp[k][c]) {
						tmp[r][c] *= 2;
						tmp[k][c] = 0;
					} else if (tmp[r][c] != tmp[k][c] && k != r - 1) {
						tmp[r - 1][c] = tmp[k][c];
						tmp[k][c] = 0;
					}
					r--;
				}
			}
			break;
		case 2: // 좌
			for (int r = 0; r < N; r++) {
				int c = 0;
				while (c < N - 1) {
					int k = c + 1;
					while (k + 1 < N && tmp[r][k] == 0) {
						k++;
					}
					if (tmp[r][k] == 0) {
						c++;
						continue;
					}
					if (tmp[r][c] == 0) {
						tmp[r][c] = tmp[r][k];
						tmp[r][k] = 0;
						continue;
					} else if (tmp[r][c] == tmp[r][k]) {
						tmp[r][c] *= 2;
						tmp[r][k] = 0;
					} else if (tmp[r][c] != tmp[r][k] && k != c + 1) {
						tmp[r][c + 1] = tmp[r][k];
						tmp[r][k] = 0;
					}
					c++;
				}
			}
			break;
		case 3: // 우
			for (int r = 0; r < N; r++) {
				int c = N - 1;
				while (c > 0) {
					int k = c - 1;
					while (k - 1 > -1 && tmp[r][k] == 0) {
						k--;
					}
					if (tmp[r][k] == 0) {
						c--;
						continue;
					}
					if (tmp[r][c] == 0) {
						tmp[r][c] = tmp[r][k];
						tmp[r][k] = 0;
						continue;
					} else if (tmp[r][c] == tmp[r][k]) {
						tmp[r][c] *= 2;
						tmp[r][k] = 0;
					} else if (tmp[r][c] != tmp[r][k] && k != c - 1) {
						tmp[r][c - 1] = tmp[r][k];
						tmp[r][k] = 0;
					}
					c--;
				}
			}
			break;
		}
		return tmp;
	}

	private static void findMax(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				max = Math.max(max, arr[i][j]);
			}
		}
	}

	private static int[][] clone(int[][] map) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			tmp[i] = map[i].clone();
		}
		return tmp;
	}
}
