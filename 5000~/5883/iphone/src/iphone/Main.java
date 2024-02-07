package iphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> hs = new HashSet<>();
		int ans = 0;
		
		int[] arr = new int [n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			hs.add(arr[i]);
		}
		
		for(int val : hs) {
			int cnt = 0;
			int num = 0;
			for(int i = 0; i<n; i++) {
				if(val == arr[i]) continue;
					
				else {
					if(i==0) {
						cnt++;
						num = arr[i];
					}
					else if(arr[i] == num) cnt++;
					else {
						cnt = 1;
						num = arr[i];
					}
				}
				
				if(ans < cnt)
					ans = cnt;
			}
		}
		
		System.out.println(ans);
	}
}
