package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	static class P{
		int x;
		int y;
		
		P(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    
	    HashMap<Integer,Long> X = new HashMap<>();
	    HashMap<Integer,Long> Y = new HashMap<>();
	    
	    P[] arr = new P[n];
	    
	    long cnt = 0;
	    //(x1,y1), (x2,y2), (x3,y3)
    	// x1==x2, y3==y1 or y3==y2 면 y축에 평행한 직각삼각형
    	// y1==y2, x3==x1 or x3==x2 면 x축에 평행한 직각삼각형
    	// (x값이 같은경우)*(y값이 같은 경우)
    	
	    for(int i = 0; i<n; i++) {
	    	st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    X.put(x, X.getOrDefault(x, (long)0)+1);
		    Y.put(y, Y.getOrDefault(y, (long)0)+1);
		    
		    arr[i] = new P(x,y);
	    }
	    
	    for(int i = 0; i<n; i++) {
	    	P now = arr[i];
	    	long cntx = X.get(now.x);
	    	long cnty = Y.get(now.y);
	    	
	    	cnt += (cntx-1)*(cnty-1);
	    }
	    
	    System.out.println(cnt);
	}
}