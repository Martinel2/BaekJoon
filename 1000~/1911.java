package solved;

import java.io.*;
import java.util.*;
 
public class Main {
 
	static class W implements Comparable<W>{
		int str;
		int end;
		
		W(int str,int end){
			this.str=str;
			this.end=end;
		}
		
		@Override
		public int compareTo(W o) {
			return this.str-o.str;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n, l;
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
 
        W[] arr = new W[n];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int str = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	arr[i] = new W(str,end);
        }
        
        Arrays.sort(arr);
        int cnt = 0;
        int len = arr[0].str;
               
        for(int i=0; i<n; i++) {
        	int dis=0;
        	
        	if(arr[i].str > len) {
        		dis = arr[i].end-arr[i].str;
        		len = arr[i].str;
        	}
        	else dis = arr[i].end-len;
        	if(dis < 0) continue;
    		int div = dis/l;
    		int mod = dis%l;
    		if(mod >0) div++;
    		cnt += div;
    		len = len +(l*div);
    		//System.out.println(len);
        }
        System.out.println(cnt);
    }
}