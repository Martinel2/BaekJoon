package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        Queue<String> in = new LinkedList<>();
        
        for(int i = 0; i<n; i++) {
        	in.add(br.readLine());
        }
        
        for(int j = 0; j<n; j++) {
        	String out = br.readLine();
        	if(out.equals(in.peek())) in.poll();
        	else {
        		ans++;
        		in.remove(out);
        	}
        }
        System.out.println(ans);
	}
}