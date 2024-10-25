package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		while(n != 0) {
			String[] arr= new String[n];
			for(int i = 0; i<n; i++) {
				arr[i] = br.readLine();
			}
			Arrays.sort(arr, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return s1.toUpperCase().compareTo(s2.toUpperCase());
				}
			});
			sb.append(arr[0]).append('\n');
			
			n = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
	}
	
}