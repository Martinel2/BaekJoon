package solved;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();		
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    char[][] arr = new char[n][m];
    for(int i = 0; i<n; i++) {
    	arr[i] = br.readLine().toCharArray();
    }
    
    boolean eyfa = true;
    for(int i=0; i<n; i++) {
    	String s = br.readLine();
    	int idx = 0;
    	for(int j=0; j<2*m; j+=2) {
    		if(s.charAt(j) != arr[i][idx] || s.charAt(j+1) != arr[i][idx]) {
    			eyfa = false;
    			break;
    		}
    		idx++;
    	}
    	if(!eyfa) break;
    }
    String ans = eyfa? "Eyfa":"Not Eyfa";
    System.out.println(ans);
  }
}