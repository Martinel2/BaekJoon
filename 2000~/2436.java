package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static long gcd(long a, long b) {
		long c = a%b;
		if(c==0) return b;
		return gcd(b,c);
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        
        int gcd,lcm;
        gcd = Integer.parseInt(st.nextToken());
        lcm = Integer.parseInt(st.nextToken());
        
        long ab = gcd*lcm;
        
        int a=0,b=0;
        
        for(int i=gcd; i<=Math.sqrt(ab); i+=gcd) {
        	if(ab%i == 0 && gcd(i,ab/i) == gcd) {
        		a=i;
        		b=(int)(ab/i);
        	}
        }
        System.out.println(a+" "+b);
    }
}