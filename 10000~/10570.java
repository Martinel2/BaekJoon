package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[1001];
			int max = 0;
			int maxNum = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				int num = Integer.parseInt(br.readLine());
				arr[num]++;
				if(max == arr[num]) {
					max = arr[num];
					if(maxNum > num)
						maxNum = num;
				}
				if(max < arr[num]) {
					max = arr[num];
					maxNum = num;
				}
			}
			sb.append(maxNum).append('\n');
		}
		System.out.println(sb);
	}
}