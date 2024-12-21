package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	static String gcd(BigInteger a, BigInteger b) {
		if(!b.equals(BigInteger.ZERO)) {
			return gcd(b,a.mod(b));
		}
		return a.toString();
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n;i++) {
        	a = a.multiply(new BigInteger(st.nextToken()));
        }
        
        int m = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m;i++) {
        	b = b.multiply(new BigInteger(st.nextToken()));
        }
        
        String res = gcd(a,b);
        if(res.length() > 9) {
        	res = res.substring(res.length()-9);
        }
        System.out.println(res);
    }
}