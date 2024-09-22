package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr= new int[n][n];
		long sum = 0;
		int right = 0;
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				right = Math.max(right, arr[i][j]);
				sum += arr[i][j];
			}
		}
		long half = sum/2;
		if(sum%2!=0) half+=1;
		int ans = 10000001;
		int left = 0;
		while(left<=right) {
			long on = 0;
			int mid = (left+right)/2;
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(mid > arr[i][j]) on += arr[i][j];
					else on += mid;
				}
			}
			if(on < half) left = mid+1;
			else if(on >= half) {
				ans = Math.min(ans, mid);
				right = mid - 1;
			}
		}
		if(ans == 10000001) ans = 0;
		System.out.println(ans);
	}
}