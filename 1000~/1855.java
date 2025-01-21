package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int k = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int n = s.length()/k;
        
        char[][] arr = new char[n][k];
        int idx = 0;
        for(int i = 0; i<n; i++) {
        	if(i % 2 == 0)
	        	for(int j = 0; j<k; j++) {
	        		arr[i][j] = s.charAt(idx);
	        		idx++;
	        	}
        	else
        		for(int j = k-1; j>=0; j--) {
            		arr[i][j] = s.charAt(idx);
            		idx++;
            	}
        }
        
        String ans = "";
        for(int i = 0; i<k; i++) {
        	for(int j = 0; j<n; j++) {
        		ans += arr[j][i];
        	}
        }
        System.out.println(ans);
    }
}
