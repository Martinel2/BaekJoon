package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] number;
	static int n, m;
	static int count;

	private static void dfs(int level, int cnt) {
		if (level >= n) {
			if (m == cnt) {
				count++;
				return;
			}
			return;
		}
		if (n-level < m-cnt)
			return;
		
		for (int i = 0; i <= 9; i++) {
			if (number[i]) {
				number[i] = false;
				dfs(level + 1, cnt + 1);
				number[i] = true;
			} else
				dfs(level + 1, cnt);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		number = new boolean[10];
		count = 0;
		
		if(m > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				number[Integer.parseInt(st.nextToken())] = true;
			}
		}
		dfs(0, 0);
		System.out.println(count);
	}
}