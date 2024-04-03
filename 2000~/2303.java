package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] digit = {1,2,3,5,7,9};
	static void backtracking(int num, int d) {
		if(d == n) {
			sb.append(num).append('\n');
			return;
		}
		
		for(int i = 0; i<6; i++) {
			int mnum = num*10 + digit[i];
			boolean next = true;
			for(int j = 2; j<=mnum/2; j++) {
				if(mnum%j == 0) {
					next = false;
					break;
				}
			}
			if(next)
				backtracking(mnum,d+1);
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		//2 3 5 7 1자리수 소수
		//2 3 5 7이 앞자리로 이루어져있으면서 소수인 수
		backtracking(2,1);
		backtracking(3,1);
		backtracking(5,1);
		backtracking(7,1);
		System.out.println(sb);
	}
}