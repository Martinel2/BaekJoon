package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long d = Long.parseLong(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        
        long nd = 0;
        long md = 0;
        
        long g = n/d + m/d + k/d;
        long def = n/d + m/d;
        long ng;
        long mg;
        long mng;
        

        long ans = k;
        
        if(n%d != 0) {
        	nd = d - (n%d);
        	ng = (k-nd)/d+1;
        	//짜장만 D개를 채우는 경우
            if(g < def+ng) {
            	ans = k-nd;
            	g = def+ng;
            }
            else if(g == def+ng)
            	ans = Math.max(ans, k-nd);
            
        }
       
        if(m%d != 0) {
        	md = d - (m%d);
        	mg = (k-md)/d+1;
        	//짬뽕만 D개를 채우는 경우
            if(g < def+mg) {
            	ans = k-md;
            	g = def+mg;
            }
            else if(g == def+mg)
            	ans = Math.max(ans, k-md);
            
        }
        
        if(n%d != 0 && m%d != 0) {
        	mng = (k-md-nd)/d+2;
        	//짜장+짬뽕 모두 D개를 채우는 경우
            if(g < def+mng) {
            	ans = k-nd-md;
            }
            else if(g == def+mng)
            	ans = Math.max(ans, k-nd-md);
            
        }
        
        System.out.println(ans);
    }
}
