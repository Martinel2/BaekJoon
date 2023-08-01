package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        HashMap<String, Integer> map = new HashMap<>();
	        HashSet<String> set = new HashSet<>();
	        int N = Integer.parseInt(br.readLine());
	        
	        for(int i = 0; i<N; i++) {
	        	st = new StringTokenizer(br.readLine(), ".");
	        	st.nextToken();
	        	String file = st.nextToken();
	        	set.add(file);
	        	map.put(file, map.getOrDefault(file, 0)+1);
	        }
	        
	       Object[] s = set.toArray();
	       Arrays.sort(s);
	       
	       for(Object val : s) {
	    	   System.out.println(val+" "+ map.get(val));
	       }
	 }
}
