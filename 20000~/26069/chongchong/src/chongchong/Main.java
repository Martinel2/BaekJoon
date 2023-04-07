package chongchong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		HashSet<String> hs = new HashSet<>();

		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			
			if(hs.size() > 0) {
				if(hs.contains(B))
					hs.add(A);
				else if(hs.contains(A))
					hs.add(B);
			}
			else if(A.equals("ChongChong") || B.equals("ChongChong")) {
				hs.add(A); hs.add(B);
			}			
		}
		
		System.out.println(hs.size());
	}
}
