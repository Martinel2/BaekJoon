package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	String s = br.readLine();
    	//접두사 또는 접미사가 펠린드롬이며, 두 부분 문자열은 같아야 한다.
    	boolean aka = true;
    	int len = (int)Math.floor((double)(s.length()/2));
    	while(len > 1) {
        	String pre = s.substring(0,len);
        	String suf = "";
        	if(s.length() %2 == 0)
        		suf = s.substring(len,s.length());
        	else
        		suf = s.substring(len+1, s.length());
        	
        	//System.out.println(pre + " " + suf);
        	
        	if(pre.equals(suf)) {
        		int left = 0;
        		int right = len-1;
        		while(left<right) {
        			if(pre.charAt(left) != pre.charAt(right)) {
        				aka = false;
        				break;
        			}
        			left++;
        			right--;
        		}
        		if(!aka) break;
        	}
        	else {
        		aka = false;
        		break;
        	}
        	
        	s = pre;
        	len = (int)Math.floor((double)(s.length()/2));
    	}
    	
    	
    	String ans = aka? "AKARAKA":"IPSELENTI";
    	
    	System.out.println(ans);
    }
}
