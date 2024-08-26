package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	static HashMap<Long, Long> hm = new HashMap<>();
	static int p,q;
	static long dp(long num) {
		if(hm.containsKey(num)) return hm.get(num);
		
		long a = (long) Math.floor(num/p);
		long b = (long) Math.floor(num/q);
		hm.put(num, dp(a) + dp(b));
		return hm.get(num);
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
                
        st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        
        hm.put(0L, 1L);
        System.out.println(dp(n));
        
    }
}