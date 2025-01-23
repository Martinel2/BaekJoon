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
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        
        int left = 0;
        int right = 1;
        for(int i = 0; i<m; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	if(i > 0 && arr[i] >= 0 && arr[i-1] < 0) {
        		left = i-1;
        		right = i;
        	}
        }
        
        int ans = Integer.MAX_VALUE;
        while(left >= 0 && right < m) {
        	int c = arr[right] + arr[left];
        	//System.out.println(arr[right] + " "+ arr[left] + " " + c);
        	if(Math.abs(ans) > Math.abs(c)) {
        		ans = c;
        	}
        	if(c==0) break;
        	else if(left+1 < right && 
        			Math.abs(ans) > Math.abs(arr[left+1] + arr[right])) left++;
        	else if(c < 0) right++;
        	else if(c > 0) left--;
        }
        
        System.out.println(ans);
    }
}
