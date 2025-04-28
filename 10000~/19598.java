package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class T implements Comparable<T>{
		int str;
		int end;
		
		T(int str, int end){
			this.str=str;
			this.end=end;
		}
		
		@Override
		public int compareTo(T o) {
			return this.str-o.str;
		}
		
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	T arr[] = new T[n];
    	
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int str= Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		
    		arr[i] = new T(str,end);
    	}
    	
    	Arrays.sort(arr);
    	
    	int idx = 0;
    	int cnt[] = new int[n];
    	for(int i=0; i<n; i++) {
    		boolean flag= false;
    		for(int j=0; j<=idx; j++) {
    			if(cnt[j] <= arr[i].str) {
    				cnt[j] = arr[i].end;
    				flag = true;
    				break;
    			}
    		}
    		if(!flag) {
    			idx++;
    			cnt[idx] = arr[i].end;
    		}
    	}
    	
    	System.out.println(idx+1);
    }
    
}
