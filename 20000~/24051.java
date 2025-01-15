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
        
        int n,k;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = -1;
        int cnt = 0;
        
        for(int i=1; i<n; i++) {
        	int loc = i-1;
        	int newItem = arr[i];
        	
        	while(0<= loc && newItem < arr[loc]) {
        		arr[loc+1] = arr[loc];
        		loc--;
        		cnt++;
        		if(cnt==k) ans = arr[loc+1];
        	}
        	if(loc + 1 != i) {
        		arr[loc+1] = newItem;
        		cnt++;
        		if(cnt==k) ans = arr[loc+1];
        	}
        }
        
        System.out.println(ans);
    }
}
