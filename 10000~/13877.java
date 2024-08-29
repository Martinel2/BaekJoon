package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	public static int conv(int n, int d) {
        int s = 0, e = 1;
        while (n > 0) {
            int m = n % 10;
            if (m >= d) {
                return 0;
            }
            s += m * e;
            n /= 10;
            e *= d;
        }
        return s;
    }
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0) {
        	st = new StringTokenizer(br.readLine());
        	int k = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	sb.append(k).append(" ").append(conv(d,8)).append(" ").append(d).append(" ").append(conv(d,16)).append('\n');
        	
        }
        System.out.println(sb);
    }
}