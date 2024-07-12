package solved;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//1분 - 6도 == 6의 배수
		String s;
		while((s = br.readLine()) != null) {
			int n = Integer.parseInt(s);
			String ans = n%6 == 0? "Y":"N";
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
} 