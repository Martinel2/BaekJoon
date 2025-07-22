package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
        long n = Integer.parseInt(br.readLine());
        long[] arr = new long[6];
        
        st = new StringTokenizer(br.readLine());
        for(int  i=0; i<6; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        long t = Integer.parseInt(st.nextToken());
        long p = Integer.parseInt(st.nextToken());
        
        long tans = 0;
        long pans = 0;
        long pmod = 0;
        for(int i=0; i<6; i++) {
        	if(arr[i] <= 0) continue;
        	if(t >= arr[i]) tans++;
        	else {
        		tans += (arr[i]/t);
        		tans += arr[i]%t > 0 ? 1:0;
        	}
        }
        pans = n/p;
        pmod = n%p;
        
        System.out.println(tans);
        System.out.println(pans + " " + pmod);
    }
}
