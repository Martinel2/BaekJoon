package d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n,m,k;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		double[] p = new double[n+1];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				int idx = Integer.parseInt(st.nextToken());
				double score = Double.parseDouble(st.nextToken());
				
				if(p[idx] < score) 
					p[idx] = score;
			}
		}
		
		Arrays.sort(p);
		
		double ans = 0;
		for(int i = n; i>n-k; i--) {
			//System.out.println(p[i]);
			ans += p[i];
		}
		
		System.out.printf("%.1f",ans);
	}
}

/*
4 4 3
4 5.0 2 4.0 3 2.0 1 1.0
2 2.0 3 1.0 1 0.5 4 0.3
4 6.0 3 5.0 2 2.0 1 0.0
1 4.0 2 3.0 4 0.6 3 0.3
*/
