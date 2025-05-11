package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0) {
        	st = new StringTokenizer(br.readLine());
        	float n = Float.parseFloat(st.nextToken());
        	int c = st.countTokens();
        	for(int i=0; i<c; i++) {
        		char op = st.nextToken().charAt(0);
        		switch(op) {
        		case '@':
        			n*=3;
        			break;
        		case '%':
        			n+=5;
        			break;
        		case '#':
        			n-=7;
        			break;
        		}
        	}
        	sb.append(String.format("%.2f", n)).append('\n');
        }
        System.out.println(sb);
    }
 }