package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int arr[][] = new int[n][2]; 
    	
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		arr[i][0] = Integer.parseInt(st.nextToken());
    		arr[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	int ans = 0;
    	for(int i=0; i<n; i++) {
    		int dis = arr[i][0];
    		int price = arr[i][1];
    		int j;
    		for(j=0; j<n; j++) {
    			if(i==j) continue;
    			
    			if(arr[j][0] < dis && arr[j][1] <= price)
    				break;
    			if(arr[j][1] < price && arr[j][0] <= dis)
    				break;
    		}
    		if(j == n) ans++;
    	}
    	System.out.println(ans);
    }
}
