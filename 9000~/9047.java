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
    	StringBuilder sb = new StringBuilder();
    	
    	int k = Integer.parseInt(br.readLine());
    	
    	while(k-->0) {
    		int ans = 0;
    		int num = Integer.parseInt(br.readLine());
    		int[] arr = new int[4];
    		while(num != 6174) {
	    		for(int i=0; i<4; i++) {
	    			arr[i] = num%10;
	    			num/=10;
	    		}
	    		Arrays.sort(arr);
	    		int max = 0;
	    		int min = 0;
	    		for(int i=0; i<4; i++) {
	    			min = min * 10 + arr[i];
	    			max = max * 10 + arr[3 - i];
	    		}
	    		num = max-min;
	    		ans++;
    		}
    		sb.append(ans).append('\n');
    	}
    	System.out.println(sb);
    }
}
