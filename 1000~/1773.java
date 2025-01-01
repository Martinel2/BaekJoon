package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] visited = new int[3001];
    static int n, m;
    static String s;

    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		boolean[] f = new boolean[c+1];
		int ans = 0;
		for(int i = 0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			int j = 1;
			while(num*j <= c) {
				if(!f[num*j]) {
					f[num*j] = true;
					ans++;
				}
				j++;
			}
		}
		System.out.println(ans);
    }
}
