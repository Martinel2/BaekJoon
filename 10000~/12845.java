package solved;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
                
        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        int sum = 0;
        int max = 0;
        
        for(int i = 0; i<n; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	
        	sum += num;
        	
        	max = Math.max(max, num);
        }
        
        sum += max*(n-2);
        
        System.out.println(sum);
    }
}