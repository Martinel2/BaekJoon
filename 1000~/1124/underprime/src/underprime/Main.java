package underprime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a,b;
		int ans = 0;
		ArrayList<Integer> prime = new ArrayList<>();
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		boolean[] che = new boolean[b+1];
		for(int i = 2; i<=b; i++) {
			if(che[i]) 
				continue;
			prime.add(i);
			for(int j = 2; i*j<=b; j++) {
				che[i*j] = true;
			}
		}
		
		for(int i = a; i<=b; i++) {
			int cnt = 0;
			int num = i;
			int idx = 0;
			while(num > 1) {
				int p = prime.get(idx);
				//System.out.println(num+" "+p);
				while(num%p == 0) {
					num /= p;
					cnt++;
				}
				idx++;
			}
			if(!che[cnt] && cnt > 1)
				ans++;
		}
		
		System.out.println(ans);
	}
}
