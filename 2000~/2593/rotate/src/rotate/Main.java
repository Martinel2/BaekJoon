package rotate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int left = 0;
		int right = k-1;
		int max = 0;
		for(int i = 0; i<n; i++) {
			HashSet<Integer> hs = new HashSet<>();
			for(int j = left; j<=right; j++) {
				int idx = j;
				if(idx >= n) idx %= n;
				hs.add(arr[idx]);
			}
			hs.add(c);
			int cnt = hs.size();
			if(max < cnt)
				max = cnt;
			left++;
			right++;
		}
		
		System.out.print(max);
	}
}
