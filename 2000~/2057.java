package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        long n = Long.parseLong(br.readLine());
        
        if(n > 0) {
	        ArrayList<Long> al = new ArrayList<>();
	        
	        long i = 0;
	        long f = 1;
	        while(f<= n) {
	        	al.add(f);
	        	i++;
	        	f = f*i;
	        	//System.out.println(f);
	        }
	        
	        Collections.sort(al, Collections.reverseOrder());
	        
	        for(long fact : al) {
	        	if(n >= fact) n-= fact;
	        	if(n == 0) break;
	        }
	        
	        String ans = n==0? "YES":"NO";
	        System.out.println(ans);
        }
        else System.out.println("NO");
    }
}