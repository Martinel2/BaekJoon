package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
       
        String ans = "";
        if(n == 0) {
        	if(m == 0) {
        		ans = "=";
        	}
        	else if(m == 5) {
        		ans = "<";
        	}
        	else {
        		ans = ">";
        	}
        }
        else if(n == 2) {
        	if(m == 2) {
        		ans = "=";
        	}
        	else if(m == 0) {
        		ans = "<";
        	}
        	else {
        		ans = ">";
        	}
        }
        else if(n == 5) {
        	if(m == 5) {
        		ans = "=";
        	}
        	else if(m == 2) {
        		ans = "<";
        	}
        	else {
        		ans = ">";
        	}
        }
        else {
        	if(m == 0 || m == 2 || m == 5) {
        		ans = "<";
        	}
        	else {
        		ans = "=";
        	}
        }
        System.out.println(ans);
    }
}