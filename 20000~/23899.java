package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	static int[] a;
	static int[] b;
	static int n;
	
	static int selection_sort() {
		int max = 0;
		int idx = 0;
	    for(int i = n-1; i>0; i--) {
	    	max = 0;
	    	idx = 0;
	        if(Arrays.equals(a, b)) return 1;
	    	for(int j = i; j>=0; j--) {
	    		if(max < a[j]) {
		    		max = Math.max(max, a[j]);
		    		idx = j;
	    		}
	    	}
	        if(idx != i) {
	        	int tmp = a[idx];
	        	a[idx] = a[i];
	        	a[i] = tmp;
	        }
	        if(Arrays.equals(a, b)) return 1;
	    }
	    return 0;
	    
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    a = new int[n];
	    b = new int[n];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i<n; i++) {
	    	a[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i<n; i++) {
	    	b[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    System.out.println(selection_sort());
	}
}