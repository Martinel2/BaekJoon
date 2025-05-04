package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static boolean isSame(int[] a1, int[] a2, int m) {
		for(int i=0; i<m; i++) {
			if(a1[i] != a2[i]) return false;
		}
		return true;
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int[][] lamp = new int[n][m];
    	
    	for(int i=0; i<n; i++) {
    		String[] in = br.readLine().split("");
    		for(int j=0; j<m; j++) {
    			lamp[i][j] = Integer.parseInt(in[j]);
    		}
    	}
    	
    	int k= Integer.parseInt(br.readLine());
    	int cnt = 0;
    	
    	for(int i=0; i<n; i++) {
    		int zcnt = 0;
    		for(int j=0; j<m; j++) {
    			if(lamp[i][j] == 0) zcnt++;
    		}
    		
    		int same = 0;
    		
    		if(zcnt <= k && zcnt%2 == k%2) {
    			for(int j=0; j<n; j++) {
    				if(isSame(lamp[i],lamp[j],m)) same++;
    			}
    		}
    		cnt = Math.max(cnt, same);
    	}
    	System.out.println(cnt);
    }
}
