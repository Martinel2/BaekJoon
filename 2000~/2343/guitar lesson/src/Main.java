import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] bl = new int[N];
		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			bl[i] = Integer.parseInt(st.nextToken());
			right += bl[i];
			left = Math.max(left, bl[i]);
		}
		
		while(left<right) {
			int mid = (left+right)/2;
			int cnt = 0;
			int sum = 0;
			for(int i = 0; i<N; i++) {
				if(sum + bl[i] > mid) {
					cnt++;
					sum=0;
				}
				sum += bl[i];			
			}
			if(sum != 0)
				cnt++;
			if(cnt > M) {
				left = mid +1;
			}
			else
				right = mid;
		}
		System.out.println(left);
	}
}
