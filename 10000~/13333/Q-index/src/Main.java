import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int min = arr[0];
		int max = arr[N-1];
		int mid = (min+max)/2;
		int ans  = 0;
		
		while(true) {
			if(mid == 0)
				break;
			//System.out.println(mid);
			if(mid > N) {
				max = mid;
				mid = (min+max)/2;
			}
			else {
				int idx = N-1;
				int cnt = 0;
				while(0 <= idx && arr[idx] >= mid) {
					idx--;
					cnt++;
				}
				if(cnt > mid) {
					min = mid;
					mid = (min+max)/2;
				}
				else if(cnt == mid){
					ans = mid;
					break;
				}
				else {
					max = mid;
					mid = (min+max)/2;
				}
			}
			
		}
		
		System.out.println(ans);
		
		
	}
}
