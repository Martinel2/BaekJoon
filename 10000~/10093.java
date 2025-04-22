package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        if(n>m) {
        	long tmp = m;
        	m = n;
        	n = tmp;
        }
        long c = m==n? 0:m-n-1;
        sb.append(c).append('\n');
        for(long i = n+1; i<m; i++) {
        	sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}