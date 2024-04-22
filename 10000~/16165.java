package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<String, String[]> group = new HashMap<>();
        
        for(int i = 0; i<n; i++) {
        	String key = br.readLine();
        	
        	int cnt = Integer.parseInt(br.readLine());
        	String[] arr = new String[cnt];
        	for(int j = 0; j<cnt; j++) {
        		arr[j] = br.readLine();
        	}
        	Arrays.sort(arr);
        	group.put(key, arr);
        }
        
        for(int i = 0; i<m; i++) {
        	String s = br.readLine();
        	int type = Integer.parseInt(br.readLine());
        	if(type == 0) {
        		String[] ans = group.get(s);
        		for(String name : ans)
        			sb.append(name).append('\n');
        	}
        	else {
        		Loop: for(String key: group.keySet()) {
        			for(String name : group.get(key)) {
        				if(s.equals(name)) {
                			sb.append(key).append('\n');
        					break Loop;
        				}
        			}
        		}
        	}
        }
        
        System.out.println(sb);
   }
}