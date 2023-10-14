import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static void merge(int[] arr, int left, int mid, int right) {
		int[] sorted = new int[arr.length];
		
		int l = left;
		int r = mid+1;
		int idx = left;
		
		while(l <= mid && r <= right) {
			if(arr[l] <= arr[r]) {
				sorted[idx] = arr[l];
				idx++;
				l++;
			}
			else {
				sorted[idx] = arr[r];
				idx++;
				r++;
			}
		}
		if(l > mid) {
			while(r <= right) {
				sorted[idx] = arr[r];
				idx++;
				r++;
			}
		}
		else {
			while(l <= mid) {
				sorted[idx] = arr[l];
				idx++;
				l++;
			}
		}
		
		for(int i = left; i<=right; i++) {
			arr[i] = sorted[i];
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cur = Integer.parseInt(br.readLine());
		
		int k = 2;
		while(cur >= k) {
			int l = 0;
			int r = k-1;
			int mid = (l+r)/2;
			while(r < arr.length) {
				merge(arr,l,mid,r);
				l += k;
				r += k;
				mid = (l+r)/2;
			}
			k *= 2;
		}
		
		for(int val : arr) {
			System.out.print(val+" ");
		}
	}
}
