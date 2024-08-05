package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i<n; i++) {
        	hs.add(br.readLine());
        }
        
        
        for(int i = 0; i<m; i++) {
        	st = new StringTokenizer(br.readLine(), ",");
        	if(!hs.isEmpty()) {
        		while(st.hasMoreTokens()) {
	        		String s= st.nextToken();
	        		//System.out.println(s + " " + hs.size());
	        		if(hs.contains(s)) {
	        			hs.remove(s);
	        		}
	        	}
        	}
        	sb.append(hs.size()).append('\n');
        }
       System.out.println(sb);
    }
}