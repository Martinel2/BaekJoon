package solved;

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] che = new boolean[N+1];
		
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i = 2; i <=N; i++) {
			if(che[i]) continue;
			else {
				al.add(i);
				for(int j = 2; i*j<=N; j++) {
					che[i*j] = true;
				}
			}
		}
		
		int len = al.size()-1;
		int ans = 0;
		
		for(int i = len; i>=0; i--) {
			int sum = al.get(i);
			if(sum == N) ans++;
			else {
				for(int j = i-1; j>=0; j--) {
					sum += al.get(j);
					if(sum == N) {
						ans++;
						break;
					}
					else if(sum > N)
						break;
				}
			}
		}
		
		System.out.println(ans);
	}
}