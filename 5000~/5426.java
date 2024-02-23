package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0) {
        	String s = br.readLine();
        	int n = (int)Math.sqrt(s.length());
        	char[][] square = new char[n][n];
        	int idx = 0;
        	
        	for(int i = 0; i<n; i++) {
        		for(int j = 0; j<n; j++) {
        			square[i][j] = s.charAt(idx);
        			idx++;
        		}
        	}
        	
        	for(int i = n-1; i>=0; i--) {
        		for(int j = 0; j<n; j++) {
        			sb.append(square[j][i]);
        		}
        	}
        	sb.append('\n');
        }
        
        System.out.println(sb);
    }
}
