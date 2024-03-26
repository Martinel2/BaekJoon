package solved;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i<n; i++) {
			int left = 0;
			int right = n-1;
			ans += good(arr,left,right,i);
		}
		System.out.println(ans);
	}
	
	
	static int good(int[] arr, int left, int right, int i) {
		int ans = 0;
		while(left < right) {
			if(arr[i] == arr[left] + arr[right]) {
				if(left != i && right != i) {
					ans++;
					return ans;
				}
				else {
					//System.out.println(left+" "+right+" "+i);
					ans += good(arr,left,right-1,i);
					ans += good(arr, left+1, right,i);
					break;
				}
			}
			if(arr[i] > arr[left] + arr[right])
				left++;
			else if(arr[i] < arr[left] + arr[right])
				right--;
		}
		if(ans > 1)
			return 1;
		
		return ans;
	}
}