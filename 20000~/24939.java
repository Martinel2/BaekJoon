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
    	
    	st = new StringTokenizer(br.readLine());
    	//1~4 1자
    	//5~9 정사각형 형태
    	long xlow=1,xhigh=Long.parseLong(st.nextToken());
    	long ylow=1,yhigh=Long.parseLong(st.nextToken());;
    	
    	long q = Long.parseLong(br.readLine());
    	
    	while(q-->0) {
    		st = new StringTokenizer(br.readLine());
    		long x = Long.parseLong(st.nextToken());
    		long y = Long.parseLong(st.nextToken());
    		int d = Integer.parseInt(st.nextToken());
    		
    		switch(d) {
    			case 1:
    				xlow = Math.max(xlow, x+1);
    				ylow=yhigh=y;
    				break;
    			case 2:
    				xhigh = Math.min(xhigh, x-1);
    				ylow=yhigh=y;
    				break;
    			case 3:
    				yhigh = Math.min(yhigh, y-1);
    				xlow=xhigh=x;
    				break;
    			case 4:
    				ylow = Math.max(ylow, x+1);
    				xlow=xhigh=x;
    				break;
    			case 5:
    				ylow = Math.max(ylow, y+1);
    				xlow = Math.max(xlow, x+1);
    				break;
    			case 6:
    				ylow = Math.max(ylow, y+1);
    				xhigh = Math.min(xhigh, x-1);
    				break;
    			case 7:
    				yhigh = Math.min(yhigh, y-1);
    				xlow = Math.max(xlow, x+1);
    				break;
    			case 8:
    				yhigh = Math.min(yhigh, y-1);
    				xhigh = Math.min(xhigh, x-1);
    				break;
    			default:
    				xlow = xhigh = x;
    				ylow = yhigh = y;
    				break;
    			}
    	}
    	long ans = (xhigh-xlow+1)*(yhigh-ylow+1);
    	
		System.out.println(ans);
    }
}
