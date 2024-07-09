package solved;

import java.io.*;

public class Main {
	private static final long MAXLIMIT = 9876543210L;
	static boolean visit[];
	static String strN;
	static long min = Long.MAX_VALUE;
	static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		strN = br.readLine();
		long N = Long.parseLong(strN);
		int len = strN.length();

		if (N >= MAXLIMIT) { // 숫자의 길이가 10이상일 경우, 숫자로 만들 수 있는 최대값이 됨
			System.out.println("9876543210");
			return;
		} else if (N <= 10) {
			System.out.println(N);
			return;
		}
		

		visit = new boolean[10];	
		if (len != 2) {
			visit[9] = true;
			DFS("9", 0, len - 2);
			visit[9] = false;
		}

		visit[Character.getNumericValue(strN.charAt(0))] = true;
		DFS( Character.toString(strN.charAt(0)) , 0, len - 1);
		visit[Character.getNumericValue(strN.charAt(0))] = false;
		
		if(len != 10) {
			visit[1] = true;
			DFS("1", 0, len);
			visit[1] = false;
		}

		System.out.println(Long.parseLong(result));
	} // End of main

	private static void DFS(String num, int depth, int depthLimit) { // 백트래킹		
		if (depth == depthLimit) {
			long temp = Long.parseLong(num);
			long diff = Math.abs(Long.parseLong(strN) - temp);
			if (min > diff) {
				min = diff;
				result = num;
			}
			
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (visit[i])
				continue;
			visit[i] = true;			
			DFS( num + Integer.toString(i),  depth + 1, depthLimit);
			visit[i] = false;
		}

	} // End of DFS
} // End of Main class