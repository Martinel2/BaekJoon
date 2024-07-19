package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String case3 = "Case #";
		for(int i = 1; i<=t; i++) {
			boolean[] num = new boolean[10];
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				sb.append(case3).append(i).append(": ").append("INSOMNIA\n");
				continue;
			}
			int cnt = 0;
			int mul = 2;
			int ccn = n;
			while(cnt != 10) {
				int cn = ccn;
				while(cn != 0) {
					int idx = cn%10;
					if(!num[idx]) {
						num[idx] = true;
						cnt++;
						if(cnt == 10)
							break;
					}
					cn/=10;
				}
				if(cnt == 10) break;
				//System.out.println(ccn + " " + cnt);
				ccn = n * mul;
				mul++;
			}
			sb.append(case3).append(i).append(": ").append(ccn).append("\n");
			
		}
		System.out.println(sb);
	}
}