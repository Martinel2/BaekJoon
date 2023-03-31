package riquid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int lnum = 0, rnum = 0;
		int right = N-1;
		int toz = Integer.MAX_VALUE;
		while(left<right) {
			int sum = Math.abs(arr[left] + arr[right]);
			if(toz > sum) {
				toz = sum;
				lnum = arr[left];
				rnum = arr[right];
			}
			if(arr[left] + arr[right] > 0)
				right--;
			else if(arr[left] + arr[right] < 0)
				left++;
			else
				break;
		}
		System.out.println(lnum+" "+rnum);
	}
}
