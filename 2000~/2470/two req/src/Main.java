import java.io.*;
import java.util.*;


//2470 µÎ ¿ë¾×
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int exc = Integer.MAX_VALUE;
		int a=0,b=0;
		int[] arr = new int[N];
		int mid = N/2;
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		
		while(left < right) {
			int mix = arr[left] + arr[right];
			if(Math.abs(mix) < Math.abs(exc)) {
				exc = mix;
				a = arr[left];
				b = arr[right];
			}
			if(mix < 0)
				left++;
			else if(mix > 0)
				right--;
			else
				break;
		}
		
		
		System.out.println(a+" "+b);
	}
}
/*
5
-2 4 -99 -1 98

6
-2 4 -100000 -200000 100010 2002020
*/