package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			hm.put(num, hm.getOrDefault(num,0)+1);
		}
		
		int max = 0;
		
		for(int val : hm.keySet()) {
			if(hm.get(val) >= 2) {
				int s = val*val;
				int sum = 0;
				while(s != 0) {
					sum += s%10;
					s/=10;
				}
				max = Math.max(max, sum);
			}
			for(int v2 : hm.keySet()) {
				if(val == v2) continue;
				int s = val*v2;
				int sum = 0;
				while(s != 0) {
					sum += s%10;
					s/=10;
				}
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);
	}

}