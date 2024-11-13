package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> in = new HashMap<>();
        
        int ans = 0;
        
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	String name = st.nextToken();
        	char op = st.nextToken().charAt(0);
        	
        	if(op == '+') {
        		in.put(name, in.getOrDefault(name, 0)+1);
        	}
        	else {
        		if(in.containsKey(name)) {
        			in.put(name, in.getOrDefault(name, 0)-1);
        			if(in.get(name) == 0) in.remove(name);
        		}
        		else ans++;
        	}
        }
        //마지막까지 들어가있으면 야근
        for(int val : in.values()) {
        	ans += val;
        }
        System.out.println(ans);
    }
}
