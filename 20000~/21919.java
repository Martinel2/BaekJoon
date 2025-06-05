package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		boolean[] che = new boolean[1000001];
		
		che[1]=true;
		for(int i=2; i<=1000000; i++) {
			if(che[i]) continue;
			
			for(int j=2; i*j<=1000000; j++) che[i*j] = true;
		}
		
		int n = Integer.parseInt(br.readLine());
		long ans = 1;
		HashSet<Integer> hs = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!che[num] && hs.add(num)) ans *= num;
		}
		
		ans = ans==1? -1:ans;
		
		System.out.println(ans);
	}
	
}