import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	int[] A;
	static int[] tmp;
	static int k;
	static int cnt = 0;
	static int result = -1;
	
	public static void mergesort(int[] A, int p, int r) {
		if(cnt > k)
			return;
		if(p < r) {
			int q = (p+r)/2;
			mergesort(A,p,q);
			mergesort(A,q+1,r);
			merge(A,p,q,r);
		}
	}
	
	static void merge(int[] A , int p, int q, int r) {
		int i = p;
		int j = q+1;
		int t = 0;
		
		while(i <= q && j <= r) {
			if(A[i] <= A[j]) 
				tmp[t++] = A[i++];
			else
				tmp[t++] = A[j++];
		}
		while(i<=q)
			tmp[t++] = A[i++];
		while(j<=r)
			tmp[t++] = A[j++];
		i = p; t = 0;
		while(i<=r) {
			cnt++;
			
			if(cnt == k) {
				result = tmp[t];
				break;
			}
			
			A[i++] = tmp[t++];
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[] A = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		tmp = new int[n];
		mergesort(A,0,n-1);
		System.out.println(result);
	}
}
