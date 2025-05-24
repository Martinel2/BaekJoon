package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main {
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long b = Long.parseLong(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Long> hm = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			long p = Long.parseLong(st.nextToken());
			hm.put(s,p);
		}
		
		long sum = 0;
		String ans ="acceptable";
		for(int i=0; i<m; i++) {
			String s = br.readLine();
			sum += hm.get(s);
		}
		if(sum > b) ans = "unacceptable";
		System.out.println(ans);
	}
}