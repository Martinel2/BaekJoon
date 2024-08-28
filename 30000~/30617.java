package solved;

import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int left = 0;
        int right = 0;
        int ans = 0;
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
            
        	int l = Integer.parseInt(st.nextToken());
        	int r = Integer.parseInt(st.nextToken());
        	
        	if(l != 0 && left == l) ans++;

        	if(r != 0 && right == r) ans++;

        	if(l != 0 && l == r) ans++;
        	
        	left = l;
        	right = r;
        }
        System.out.println(ans);
    }
}