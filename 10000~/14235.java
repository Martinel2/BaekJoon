package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i =0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	if(a == 0) {
        		if(!p.isEmpty()) sb.append(p.poll());
        		else sb.append(-1);
        		sb.append('\n');
        	}else {
        		for(int j=0; j<a; j++) {
        			p.add(Integer.parseInt(st.nextToken()));
        		}
        	}
        }
        System.out.println(sb);

    }
}