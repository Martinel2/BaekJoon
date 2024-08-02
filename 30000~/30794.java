package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
       int n = Integer.parseInt(st.nextToken());
       String status = st.nextToken();
       
       int ans = 0;
       
       switch(status) {
	       case "miss":
	    	   ans = n*0;
	    	   break;
	       case "bad":
	    	   ans = n*200;
	    	   break;
	       case "cool":
	    	   ans = n*400;
	    	   break;
	       case "great":
	    	   ans = n*600;
	    	   break;
	       case "perfect":
	    	   ans = n*1000;
	    	   break;
       }
       System.out.println(ans);
       
       
    }
}