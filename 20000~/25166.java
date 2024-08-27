package solved;

import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
                
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        String ans = "";
        if(n < 1024) ans = "No thanks";
        else {
        	n -= 1023;
        	if((n&q) == n) ans = "Thanks";
        	else ans = "Impossible";
        }
        
        System.out.println(ans);
    }
}