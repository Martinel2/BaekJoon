package arrow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Arrow implements Comparable<Arrow>{
		int color;
		int dis;
		
		Arrow(int dis, int color){
			this.dis = dis;
			this.color = color;
		}

		@Override
		public int compareTo(Arrow o) {
			if(this.color == o.color)
				return this.dis - o.dis;
			else return this.color - o.color;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long ans = 0;
		int n = Integer.parseInt(br.readLine());
		Arrow[] arr = new Arrow[n];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int dis = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			
			arr[i] = new Arrow(dis, color);
		}
		
		Arrays.sort(arr);
		
		int lcolor = -1;
		for(int i = 0; i<n; i++) {
			int left = Integer.MAX_VALUE;
			int right = Integer.MAX_VALUE;
			if(i<n-1 && arr[i].color == arr[i+1].color)
				right = arr[i+1].dis - arr[i].dis;
			if(lcolor == arr[i].color)
				left = arr[i].dis - arr[i-1].dis;
			
			lcolor = arr[i].color;
			if(left == Integer.MAX_VALUE && right == Integer.MAX_VALUE)
				continue;
			ans += Math.min(left, right);
		}
		System.out.println(ans);
	}
}
