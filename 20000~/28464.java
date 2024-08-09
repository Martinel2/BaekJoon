package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int s = 0;
        int p = 0;
        int sidx = 0;
        int pidx = n-1;
        
        while(sidx <= pidx) {
        	p += arr[pidx];
        	pidx--;
        	
        	if(sidx>pidx) break;
        	else {
        		s+= arr[sidx];
        		sidx++;
        	}
        }
        System.out.println(s+ " " + p);
    }
}