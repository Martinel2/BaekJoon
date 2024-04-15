package solved;

import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer> arr = new ArrayList<>();
	static int max = 0;
	static int n;
	static void backtracking(int size, int sum) {
		/*for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("\n"+sum);
		*/
		
		// pick k, arr[k-1]*arr[k+1]
		if(size == 2) {
			if(max < sum)
				max = sum;
			return;
		}
		
		for(int i = 1; i<size-1; i++) {
			int num = arr.get(i);
			arr.remove(i);
			backtracking(size-1,sum+arr.get(i-1)*arr.get(i));
			arr.add(i,num);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		backtracking(n,0);
		System.out.println(max);
   }
}