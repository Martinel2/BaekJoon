package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine(), ",");
			int len = st.countTokens();
			HashMap<String, Integer> tags = new HashMap<>();
		 
			for(int i=0;i<len; i++) {
				String[] p = st.nextToken().split(":");
				tags.put(p[0],Integer.parseInt(p[1]));
			}
			st = new StringTokenizer(br.readLine(), "|");
			int n = st.countTokens();
			int min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				String[] tag = st.nextToken().split("&");
				int sum = 0;
				for(int j=0; j<tag.length; j++) {
					sum = Math.max(tags.get(tag[j]),sum);
				}
				if(min > sum) min = sum;
			}
			sb.append(min).append('\n');
		}
		System.out.println(sb);
    }
}
