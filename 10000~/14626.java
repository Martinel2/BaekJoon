package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;
        
        String s = br.readLine();
        int m;
        int isbn = 0;
        int idx = 0;
        for(int i = 0; i<13; i++) {
        	if(s.charAt(i) != '*') {
	        	if(i%2 == 0) {
	        		isbn += s.charAt(i) - '0';
	        		
	        	}
	        	else {
	        		isbn += 3 * (s.charAt(i) - '0');
	        	}
        	}
        	else {
        		if(i%2 == 0) {
            		idx = 1;
            		
            	}
            	else {
            		idx = 3;
            	}
        	}
        }
        m = s.charAt(12) - '0';
        for(int i = 0; i <10; i++) {
        	int num = idx * i;
        	
        	if((isbn+num)%10 == 0) {
        		System.out.println(i);
        		break;
        	}
        }
    }
}