package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int c[] = new int[n];
        
        int m,x;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        int max = 0;
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int ci = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if(m >= ci) {
            	max = Math.max(max, p);
            }
        }
        
        String ans = max > x ? "YES":"NO";
        System.out.println(ans);
    }
}
