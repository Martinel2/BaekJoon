package solved;

import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] jewel = new int[m];
		int max = 0;
		for(int i = 0; i<m ;i++) {
			jewel[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, jewel[i]);
		}
		
		//보석을 분할
		//보석 나누어주기
		//모든 보석을 나누어주어야함. 모든 사람이 받을 필요는 없음
		int ans = Integer.MAX_VALUE;
		if(max > 1)
		{
			int left = 0;
			int right = max;
			while(left <= right) {
				int mid = (left+right)/2;
				if(mid == 0) break;
				int cnt = 0;
				for(int i=0; i<m; i++) {
					cnt += jewel[i]/mid;
					if(jewel[i]%mid > 0) cnt++;
					if(cnt > n) break;
				}
				//System.out.println(mid);
				if(cnt <= n) {
					ans = Math.min(ans, mid);
					right = mid -1;
				}
				if(cnt > n) {
					left = mid+1;
				}
			}
		}
		else ans = 1;
		System.out.println(ans);
	}
}
