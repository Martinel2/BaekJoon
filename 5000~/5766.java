package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    while(n != 0 || m != 0) {
		    HashMap<Integer,Integer> hm = new HashMap<>();
		    ArrayList<Integer> al = new ArrayList<>();
		    
		    int max = 0;
		    int secMax = 0;
		    for(int i = 0; i<n; i++) {
		    	st = new StringTokenizer(br.readLine());
		    	for(int j =0; j<m; j++) {
		    		int num = Integer.parseInt(st.nextToken());
		    		hm.put(num, hm.getOrDefault(num, 0)+1);
		    		int score = hm.get(num);
		    		max = Math.max(max, score);
		    	}
		    }
		    
		    for(int val : hm.values()) {
		    	if(max != val) {
		    		secMax = Math.max(val, secMax);
		    	}
		    }
		    
		    for(int num : hm.keySet()) {
		    	int score = hm.get(num);
		    	if(score == secMax) {
		    		al.add(num);
		    	}
		    }
		    Collections.sort(al);
		    for(int val : al) sb.append(val).append(" ");
		    sb.append('\n');
		    
		    st = new StringTokenizer(br.readLine());
		    n = Integer.parseInt(st.nextToken());
		    m = Integer.parseInt(st.nextToken());
	    }
	    System.out.println(sb);
	}
}