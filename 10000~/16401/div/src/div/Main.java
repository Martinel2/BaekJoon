package div;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n,m;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr[m-1];
		
		int mid = (left + right)/2;
		
		while(left < right && left < mid && mid < right) {
			//System.out.println(left+" "+right+" "+mid);
			int cnt = 0;
			for(int i = m-1; i>=0; i--) {
				cnt += arr[i]/mid;
				
				if(cnt == n)
					break;
			}
			
			if(cnt == n) 
				left = mid;
			else 
				right = mid;
			
			mid = (left + right)/2;
		}
		
		System.out.println(mid);
	}
}
