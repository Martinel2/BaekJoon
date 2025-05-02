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
    	
    	long[][] arr = new long[3][2];
    	
    	for(int i=0; i<3; i++) {
    		st = new StringTokenizer(br.readLine());
    		arr[i][0] = Long.parseLong(st.nextToken());
    		arr[i][1] = Long.parseLong(st.nextToken());
    	}
    	
    	// 흰 검 흰
    	long a = Math.min(Math.min(arr[0][0], arr[2][0]),arr[1][1]);
    	
    	// 검 흰 검
    	long b = Math.min(Math.min(arr[0][1], arr[2][1]),arr[1][0]);
    	
    	
    	
    	System.out.println(Math.min(a, b+1) + Math.min(a+1, b));
    }
}
