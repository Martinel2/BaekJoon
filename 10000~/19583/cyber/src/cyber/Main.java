package cyber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		
		 String S = st.nextToken();
	     String E = st.nextToken();
	     String Q = st.nextToken();
		
		HashSet<String> member = new HashSet<>();
		
		String s = null;
		while((s=br.readLine()) != null) {
			st = new StringTokenizer(s);
			String time = st.nextToken();
			String name = st.nextToken();
			
			if(S.compareTo(time) >= 0) {
                member.add(name);
            }else if(E.compareTo(time) <= 0 && Q.compareTo(time) >= 0 
            		&& member.contains(name)) {
                cnt++;
            	member.remove(name);
            }
		}
		System.out.println(cnt);
		br.close();
	}
}
