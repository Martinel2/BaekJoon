package seq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2491
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int highCnt = 1, lowCnt = 1;
		int highN = arr[0], lowN = arr[0];
		int ans = 1;
		
		for(int i = 1; i<N; i++) {
			//System.out.println("highCnt = "+highCnt + " lowCnt = "+lowCnt);
			if(highN <= arr[i]) {
				highN = arr[i];
				highCnt++;
			}
			else {
				highN = arr[i];
				ans = Math.max(ans, highCnt);
				highCnt = 1;
			}
			
			if(lowN >= arr[i]) {
				lowN = arr[i];
				lowCnt++;
			}
			else {
				lowN = arr[i];
				ans = Math.max(ans, lowCnt);
				lowCnt = 1;
			}
		}
		ans = Math.max(ans, Math.max(lowCnt, highCnt));
		System.out.println(ans);
	}
}
