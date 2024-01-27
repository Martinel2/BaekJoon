package num;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num]++;
			if(arr[num] > 1) {
				ans = num;
				break;
			}
		}
		
		System.out.print(ans);
	}
}
