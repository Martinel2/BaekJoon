package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long div(long num) {
		if(num==1) return 0;
		long d1 = num/2;
		long d2 = num-d1;
		long sum = d1*d2;
		return sum + div(d1) + div(d2);
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        System.out.println(div(n));
    }
}    