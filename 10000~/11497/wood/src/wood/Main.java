package wood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t= Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr =new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int max = arr[1] - arr[0];
			int left = 0;
			int right = 0;
			for(int i = 2; i<n; i+=2) {
				int che = arr[i] - arr[i-2];
				max = Math.max(max, che);
				if(i+2 >=n)
					left = che;
			}
			for(int i = 3; i<n; i+=2) {
				int che = arr[i] - arr[i-2];
				max = Math.max(max, che);
				if(i+2 >=n)
					right = che;
			}
			max = Math.max(max, Math.abs(left-right));
			sb.append(max).append('\n');
		}
		System.out.println(sb);
	}
}
