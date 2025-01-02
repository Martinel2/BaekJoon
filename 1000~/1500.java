package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
	
		int div = s/k;
		int mod = s%k;
		
		long max = 1;
		for(int i =1; i<=k; i++) {
			if(i<=mod) {
				max *= (div+1);
			}else max *= div;
		}
		
		System.out.println(max);
		
    }
}
