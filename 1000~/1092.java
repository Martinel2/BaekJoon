package solved;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] crane = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) { 
        	crane[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane);
        int cmax = crane[n-1];
        
        
        int m = Integer.parseInt(br.readLine());
        int[] box = new int[m];
        boolean[] c = new boolean[m];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) box[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(box);
        int max = box[m-1];
        
        int ans = 0;
        
        if(max > cmax) ans = -1;
        
        else {
	        int cnt = 0;
	        while(cnt < m) {
	        	ans++;
	        	int idx = n-1;
	        	for(int i = m-1; i>=0; i--) {
	        		if(box[i] <= crane[idx] && !c[i]) {
	        			c[i] = true;
	        			cnt++;
	        			idx--;
	        			if(idx < 0)
	        				break;
	        		}
	        	}
	        }
        }
        System.out.println(ans);
    }
}