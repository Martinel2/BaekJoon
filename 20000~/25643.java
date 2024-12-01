package solved;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean clear  = true;
        String s = br.readLine();
        for(int i = 1; i<n; i++) {
        	String s2 = br.readLine();
        	if(!clear) continue;
        	boolean can = false;
        	for(int j=1; j<=m; j++) {
        		if(s.startsWith(s2.substring(m-j)) || s2.startsWith(s.substring(m-j))) {
        			can = true;
        		}	
        		
        	}
        	if(!can) clear = false;
        	s = s2;
        }
        
        int ans = clear? 1:0;
        System.out.println(ans);
    }
}