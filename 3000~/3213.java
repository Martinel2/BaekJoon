package solved;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] cnt = new int[3]; // 0: 1/4, 1: 1/2 2: 3/4
		
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			if(s.equals("1/2")) {
				cnt[1]++;
				if(cnt[1] % 2 == 0) {
					ans++;
					cnt[1] -= 2;
				}
			}
			else if(s.equals("1/4")) {
				cnt[0]++;
				if(cnt[2] > 0) {
					ans++;
					cnt[2]--;
					cnt[0]--;
				}
			}
			else { // 3/4
				cnt[2]++;
				if(cnt[0] > 0) {
					ans++;
					cnt[2]--;
					cnt[0]--;
				}
			}
		}

		while(cnt[0] > 0 && cnt[1] > 0) {
			ans++;
			cnt[0]--;
			cnt[1]--;
		}
		while(cnt[0] > 0 && cnt[2] > 0) {
			ans++;
			cnt[0]--;
			cnt[2]--;
		}
        while(cnt[0] >= 4) {
			ans++;
			cnt[0]-=4;
			if(cnt[0] < 4) {
				ans++;
				cnt[0] = 0;
			}
		}
		ans+= cnt[0] + cnt[1] + cnt[2];
		System.out.println(ans);
	}
}