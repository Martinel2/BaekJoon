package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static int[] arr = {1,2,3,4,5,6,7,8,9,10,
			11,12,13,14,15,16,17,18,19,20};
	
	static void reverse(int str, int end) {
		while(str < end) {
			int tmp = arr[str];
			arr[str] = arr[end];
			arr[end] = tmp;
			str++;
			end--;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			reverse(a,b);
		}
		
		for(int i=0; i<20; i++)
			System.out.print(arr[i]+" ");
	}
}