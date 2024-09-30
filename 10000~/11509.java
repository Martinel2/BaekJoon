package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	
		int n = Integer.parseInt(br.readLine());
		
		int ans = 0;
		int[] arr = new int[1000001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			int num = (Integer.parseInt(st.nextToken()));
			if(arr[num] > 0) {
				arr[num]--;
				arr[num-1] += 1;
			}else {
				arr[num-1]++;
			}
		}
		
		for(int val : arr) {
			ans += val;
		}
		
		
		System.out.println(ans);
	}
}