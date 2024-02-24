package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n;
        int sc = 1;
        
        while((n = Integer.parseInt(br.readLine())) != 0) {
        	String[] name = new String[n];
        	boolean[] ear = new boolean[n];
        	for(int i = 0; i<n; i++) {
        		name[i] = br.readLine();
        	}
        	
        	for(int i = 0; i<2*n-1; i++) {
        		st= new StringTokenizer(br.readLine());
        		int num = Integer.parseInt(st.nextToken())-1;
        		ear[num] = !ear[num];
        	}
        	
        	for(int i = 0; i<n; i++) {
        		if(ear[i]) {
        			sb.append(sc).append(" ").append(name[i]).append('\n');
        			break;
        		}
        	}
        	sc++;
        }
        System.out.println(sb);
    }
}
