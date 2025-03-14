package solved;

import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr= new int[n+1][m+1];
        
        int total = 0;
        
        for(int i=1; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int d= Integer.parseInt(st.nextToken());
        	int money = Integer.parseInt(st.nextToken());
        	total+= money;
        	
        	for(int j=1; j<=m; j++) {
            	if(j < d) {
            		arr[i][j] = arr[i-1][j];
            	}
            	else {
            		arr[i][j] = Math.max(arr[i-1][j-d]+money, arr[i-1][j]);
            	}
            }
        }
        System.out.println(total-arr[n][m]);
    }
}