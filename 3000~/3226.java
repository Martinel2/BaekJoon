package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int sam = 7;
        int spm = 19;
        for(int i =0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	String[] time = st.nextToken().split(":");
        	int r = Integer.parseInt(st.nextToken());
        	
        	int h = Integer.parseInt(time[0]);
        	int m = Integer.parseInt(time[1]);
        	
        	if(sam <= h && h < spm) {
        		if(h+(m+r)/60 < spm) ans += r*10;
        		else {
        			//System.out.println("why" + h+(m+r/60) + " ");
        			ans += 10*(60-m);
        			r= r-(60-m);
        			h++;
        			m=0;
        			int conh = r/60;
        			int remm = r%60;
        			for(int j=1; j<=conh; j++) {
        				if(h>=spm) break;
        				ans += 60*10;
        				h++;
        			}
        			ans += 5*remm;
        		}
        	}
        	else if(sam > h || h >= spm) {
        		int tot = (h+(m+r)/60)%24;
        		if(tot < sam || tot >= spm) ans += r*5;
        		else {
        			//System.out.println((h+(m+r)/60)%24);
        			ans += 5*(60-m);
        			//System.out.println(ans);
        			r = r-(60-m);
        			h = (h+1)%24;
        			m=0;
        			int conh = r/60;
        			int remm = r%60;
        			for(int j=1; j<=conh; j++) {
        				if(sam <= h && h < spm) break;
        				ans += 60*5;
        				h = (h+1)%24;
        			}
        			ans += 10*remm;
        		}
        	}
        }
        System.out.println(ans);
    }
}