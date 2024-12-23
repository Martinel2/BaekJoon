package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class V implements Comparable<V>{
		int x;
		int a;
		
		V(int x, int a){
			this.x = x;
			this.a=a;
		}
		
		@Override
		public int compareTo(V o) {
			if(this.x == o.x) return this.a-o.a;
			return this.x-o.x;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        V[] arr = new V[n];
        long total = 0;
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x= Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	arr[i] = new V(x,a);
        	total += a;
        }
        Arrays.sort(arr);
        long ans = 0;
        for(V now : arr) {
        	ans += now.a;
        	
        	if(ans >= (total+1)/2) {
        		ans = now.x;
        		break;
        	}
        }
        System.out.println(ans);
    }
}