package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());

        int ans = 0;
        long num = a;
      
        while(num <= n) {
        	ans += n/num;
        	num *= a;
        }
        System.out.println(ans);
    }
}