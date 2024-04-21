package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[1001][1001];
        int[] paper = new int[n+1];
        
        for(int i = 1; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int strx = Integer.parseInt(st.nextToken());
        	int stry = Integer.parseInt(st.nextToken());
        	int width = Integer.parseInt(st.nextToken());
        	int height = Integer.parseInt(st.nextToken());
        	
        	for(int j = strx; j<strx+width; j++) {
        		for(int k = stry; k<stry+height; k++) {
        			arr[j][k] = i;
        		}
        	}
        }
        
        for(int i = 0; i<1001; i++) {
        	for(int j = 0; j<1001; j++) {
        		paper[arr[i][j]]++;
        	}
        }
        
        for(int i =1; i<=n; i++) {
        	System.out.println(paper[i]);
        }
    }
}