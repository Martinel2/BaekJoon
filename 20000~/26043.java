package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class S{
		int num;
		int want;
		
		S(int num, int want){
			this.num=num;
			this.want=want;
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	int n = Integer.parseInt(br.readLine());
    	
    	Queue<S> line = new LinkedList<>();
    	ArrayList<Integer> A = new ArrayList<>();
    	ArrayList<Integer> B = new ArrayList<>();
    	ArrayList<Integer> C = new ArrayList<>();
    
    	for(int i = 0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int s = Integer.parseInt(st.nextToken());
    		if(s == 1) {
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			line.add(new S(a,b));
    		}
    		else {
    			int b = Integer.parseInt(st.nextToken());
    			S d = line.poll();
    			if(b == d.want) A.add(d.num);
    			else B.add(d.num); 
    		}
    	}
    	for(S rem : line) C.add(rem.num);
    	
    	Collections.sort(A);
    	Collections.sort(B);
    	Collections.sort(C);
    	
    	if(A.size() > 0) for(int val : A) sb.append(val).append(" ");
    	else sb.append("None");
    	
    	sb.append('\n');
    	
    	if(B.size() > 0) for(int val : B) sb.append(val).append(" ");
    	else sb.append("None");
    	
    	sb.append('\n');
    	
    	if(C.size() > 0) for(int val : C) sb.append(val).append(" ");
    	else sb.append("None");
    	
    	System.out.println(sb);
    }
}