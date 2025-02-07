package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	static long gcd(long a, long b) {
		if(b == 0) return a;
		else return gcd(b,a%b);
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int q = Integer.parseInt(br.readLine());
        long ansp = 0;
        long ansc = 0;
        while(q-->0) {
        	st = new StringTokenizer(br.readLine());
        	long child = Integer.parseInt(st.nextToken());
        	long parent = Integer.parseInt(st.nextToken());
        	
        	long a = Math.max(child, parent);
        	long b = Math.min(child, parent);
        	
        	long mod = gcd(a,b);

        	long p = parent;
        	if(p > mod)
        		p = p/mod;
        	a= Math.max(ansp, p);
        	b= Math.min(ansp, p);
        	ansp = a*b / gcd(a,b);

        	long c = child;
        	if(c>mod) {
        		c /= mod;
        	}
        	while(p != 1 && c > p) {
        		c -= p;
        	}
        	a= Math.max(ansc, c);
        	b= Math.min(ansc, c);
    		ansc = gcd(a,b);

        }
        if(ansp == 0) ansp = 1;
        System.out.print(ansc+" "+ansp);
    }
}