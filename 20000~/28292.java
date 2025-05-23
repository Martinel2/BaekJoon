package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = {1, 1, 2, 2, 2, 3};
		
		int ans = 0;
		if(n>=6) {
			ans = arr[arr.length-1];
		}else ans = arr[n-1];
		
		System.out.println(ans);
	}
}