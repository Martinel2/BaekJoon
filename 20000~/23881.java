package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	static int k;
	static int a=0,b=0;
	
	static void sort(int[] arr, int cnt, int last) {
		if(last == 0) return;
		int max = arr[last];
		int midx = last;
		for(int i= last-1; i>=0; i--) {
			if(max < arr[i]) {
				max = arr[i];
				midx = i;
			}
		}
		if(last != midx) {
			int temp = arr[midx];
			arr[midx] = arr[last];
			arr[last] = temp;
			cnt++;
			
			if(cnt == k) {
				a = arr[midx];
				b = arr[last];
				return;
			}
		}
		
		sort(arr,cnt,last-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sort(arr,0,n-1);
		if(a==0 && b == 0) System.out.println(-1);
		else System.out.println(a+" "+b);
	}
}