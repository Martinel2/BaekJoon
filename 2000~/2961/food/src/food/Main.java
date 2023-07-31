package food;

import java.util.*;
import java.io.*;

public class Main {
	static int N, min = Integer.MAX_VALUE;
	static boolean[] ck;
	static ArrayList<Integer> S = new ArrayList<>();
	static ArrayList<Integer> B = new ArrayList<>();
	
	static void sol(int cnt, int as, int s, int b) {
		if (cnt >= 1) {
			min = Math.min(Math.abs(s - b), min);			
		}
		for (int i = as; i < N; i++) {
			if (ck[i]) continue;
			ck[i] = true;
			sol(cnt + 1, i, s * S.get(i), b + B.get(i));
			ck[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ck = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S.add(Integer.parseInt(st.nextToken()));
			B.add(Integer.parseInt(st.nextToken()));
		}
		sol(0, 0, 1, 0);
		System.out.println(min);
	}
}