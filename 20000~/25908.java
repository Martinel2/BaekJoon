package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	static long count(int x) {
		long ret = 0;  
		for (int l = 1, r; l <= x; l = r + 1) {  
	      int cnt = x / l;  
	      r = x / (x / l);  
	      int len = r - l + 1;  
	      int even = r / 2 - (l - 1) / 2;  
	      int odd = len - even;  
	  
	      ret += (long)(even - odd) * cnt;  
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int s = Integer.parseInt(st.nextToken());
	    int t = Integer.parseInt(st.nextToken());
	    
	    System.out.println(count(t)-count(s-1));
	}
}