package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int m = Integer.parseInt(br.readLine());
        long sum = 0;
        int xor = 0;
        while(m-->0) {
        	st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	
        	if(num == 1) {
        		int x = Integer.parseInt(st.nextToken());
        		sum += x;
        		xor ^= x;
        	}else if(num == 2) {
        		int x = Integer.parseInt(st.nextToken());
        		sum -= x;
        		xor ^= x;
        	}else if(num == 3) {
        		sb.append(sum).append('\n');
        	}else {
        		sb.append(xor).append('\n');
        	}
        }
        System.out.println(sb);
    }
}
