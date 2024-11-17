package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	  public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int maxVal = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			maxVal = Math.max(maxVal, arr[i]);
		}
		int leftMaxValIdx = Integer.MAX_VALUE;
		int rightMaxValIdx = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if(maxVal == arr[i]) {
				leftMaxValIdx = Math.min(leftMaxValIdx, i);
				rightMaxValIdx = Math.max(rightMaxValIdx,i);
			}
		}
		
		int R = N-1-rightMaxValIdx;
		int B = leftMaxValIdx;

		if(R==B) {
			System.out.println("X");
		}else if(R>B) {
			System.out.println("R");
		}else {
			System.out.println("B");
		}	
	  }
}