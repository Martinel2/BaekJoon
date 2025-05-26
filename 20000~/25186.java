package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 옷의 개수 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long person = 0; // 전체 인원 수
		int max = 0; // 가장 많은 옷 수
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
			person += list.get(i);
			max = Math.max(max, list.get(i));
		}
		
		// 예외 케이스 옷이 1벌일 때, 인원 수가 1명이면 Happy
		if (n == 1 && person == 1) {
			sb.append("Happy");
		} else if (person / 2 < max) { // (전체 인원 수 / 2) 보다 제일 큰 값이 크다면
			sb.append("Unhappy");
		} else {
			sb.append("Happy");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}