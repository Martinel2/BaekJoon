package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashMap<Character, Character> hm = new HashMap<>();
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	char a = st.nextToken().charAt(0);
        	st.nextToken();
        	char b = st.nextToken().charAt(0);
        	//System.out.println(a + " " + b);
        	hm.put(a,b);
        }
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	char a = st.nextToken().charAt(0);
        	st.nextToken();
        	char b = st.nextToken().charAt(0);
        	//System.out.println(a + " " + b);
        	
        	boolean aIsb = false;
        	while(true) {
        		if(hm.containsKey(a)) {
        			char x = hm.get(a);
        			if(x == b) {
        				aIsb = true;
        				break;
        			}
        			a = x;
        		}
        		else break;
        	}
        	String ans = aIsb ? "T" : "F";
        	sb.append(ans).append('\n');
        }
        System.out.println(sb);
        
    }
}