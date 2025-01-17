package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static class T implements Comparable<T>{
		int h;
		int g;
		
		T(int h, int g){
			this.h = h;
			this.g = g;
		}

		@Override
		public int compareTo(T o) {
			if(this.g == o.g) return o.h - this.h;
			return this.g - o.g;
		}
		
		
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        //6, 10, 12, 14, 14
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        T[] tree = new T[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] =Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	int grow =Integer.parseInt(st.nextToken());
        	
        	tree[i] = new T(arr[i], grow);
        }
        Arrays.sort(tree);
        long ans = 0;
        for(int i=0; i<n; i++) {
        	//System.out.println(tree[i].h + tree[i].g*i);
        	ans += tree[i].h + tree[i].g*i;
        }
        System.out.println(ans);
    }
}
